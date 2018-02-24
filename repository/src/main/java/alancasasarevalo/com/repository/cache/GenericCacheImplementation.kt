package alancasasarevalo.com.repository.cache

import alancasasarevalo.com.repository.DBHelper
import alancasasarevalo.com.repository.buildDBHelper
import alancasasarevalo.com.repository.dao.ActivityDAO
import alancasasarevalo.com.repository.dao.ShopDAO
import alancasasarevalo.com.repository.model.ActivityEntity
import alancasasarevalo.com.repository.model.ShopEntity
import alancasasarevalo.com.repository.network.DispatchOnMainThread
import android.content.Context
import java.lang.ref.WeakReference

class GenericCacheImplementation(context: Context) : GenericCacheInterface<ShopEntity, ActivityEntity> {

    private val weakContext = WeakReference<Context>(context)

    override fun getAllElements(successCompletionElement: (elements: List<ShopEntity>, List<ActivityEntity>) -> Unit, errorCompletion: (errorMessage: String) -> Unit) {
        Thread(Runnable {

            var shops = ShopDAO(cacheDBHelper()).queryListElement()
            var activities = ActivityDAO(cacheDBHelper()).queryListElement()

            DispatchOnMainThread(Runnable {
                when {
                    shops.count() > 0 && activities.count() > 0 -> successCompletionElement(shops, activities)

                    else -> errorCompletion("Error to query shops")
                }
                cacheDBHelper().close()
            })

        }).run()
    }

    // TODO:Posible fallo al grabar por que no diferencia entre actividades y tiendas en el cache
    override fun saveAllElements(elementsT: List<ShopEntity>, elementsZ: List<ActivityEntity>, successCompletion: (List<ShopEntity>, List<ActivityEntity>) -> Unit, errorCompletion: (errorMessage: String) -> Unit) {
        Thread(Runnable {

            try {

                elementsT.forEach{
                    ShopDAO(cacheDBHelper()).insertElement(it)
                    elementsZ.forEach {
                        ActivityDAO(cacheDBHelper()).insertElement(it)
                        DispatchOnMainThread(Runnable {
                            successCompletion(elementsT, elementsZ)
                        })
                    }
                }

            } catch (e: Exception) {
                DispatchOnMainThread(Runnable {
                    errorCompletion("Error inserting shops")
                })
            }

        }).run()
    }

    override fun deleteAllElements(successCompletionElementT: () -> Unit, successCompletionElementZ: () -> Unit, errorCompletion: (errorMessage: String) -> Unit) {
        Thread(Runnable {
            var successShopsDeleted = ShopDAO(cacheDBHelper()).deleteAllElementList()
            var successActivitiesDeleted = ActivityDAO(cacheDBHelper()).deleteAllElementList()

            DispatchOnMainThread(Runnable {
                if (successShopsDeleted || successActivitiesDeleted) {
                    successCompletionElementT()
                    successCompletionElementZ()
                    cacheDBHelper().close()
                } else {
                    errorCompletion("Error deleting")
                }
            })

        }).run()
    }

    //TODO: No se si es aqui el error de diferenciar entre actividades y tiendas
    private fun cacheDBHelper(): DBHelper {
        return buildDBHelper(weakContext.get()!!, "GoToShopping.sqlite", 1)
    }

}