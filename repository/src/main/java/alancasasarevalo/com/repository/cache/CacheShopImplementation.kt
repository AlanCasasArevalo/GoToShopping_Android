package alancasasarevalo.com.repository.cache

import alancasasarevalo.com.repository.DBHelper
import alancasasarevalo.com.repository.buildDBHelper
import alancasasarevalo.com.repository.dao.ActivityDAO
import alancasasarevalo.com.repository.dao.ShopDAO
import alancasasarevalo.com.repository.model.ShopEntity
import alancasasarevalo.com.repository.network.DispatchOnMainThread
import android.content.Context
import java.lang.ref.WeakReference

class CacheShopImplementation(context: Context): CacheInterface<ShopEntity>  {

    private val weakContext = WeakReference<Context>(context)

    override fun getAllElements(successCompletion: (elements: List<ShopEntity>) -> Unit, errorCompletion: (errorMessage: String) -> Unit) {
        Thread(Runnable {

            var shops = ShopDAO(cacheDBHelper()).queryListElement()

            DispatchOnMainThread(Runnable {
                if (shops.count() > 0){
                    successCompletion(shops)
                }else{
                    errorCompletion("Error to query shops")
                }
            })

        }).run()
    }

    override fun saveAllElements(elements: List<ShopEntity>, successCompletion: () -> Unit, errorCompletion: (errorMessage: String) -> Unit) {
        Thread(Runnable {

            try {
                elements.forEach{ ShopDAO(cacheDBHelper()).insertElement(it) }
                DispatchOnMainThread(Runnable{
                    successCompletion()
                })

            }catch(e: Exception){
                DispatchOnMainThread(Runnable {
                    errorCompletion("Error inserting shops")
                })
            }

        }).run()
    }

    override fun deleteAllElements(successCompletion: () -> Unit, errorCompletion: (errorMessage: String) -> Unit) {
        Thread(Runnable {
            var successDeleting = ActivityDAO(cacheDBHelper()).deleteAllElementList()

            DispatchOnMainThread(Runnable {
                if (successDeleting){
                    successCompletion()
                }else{
                    errorCompletion("Error deleting")
                }
            })

        }).run()
    }


    private fun cacheDBHelper(): DBHelper {
        return  buildDBHelper(weakContext.get()!!, "GoToShopping.sqlite", 1)
    }

}