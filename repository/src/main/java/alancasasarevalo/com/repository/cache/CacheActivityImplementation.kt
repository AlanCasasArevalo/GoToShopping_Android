package alancasasarevalo.com.repository.cache

import alancasasarevalo.com.repository.DBHelper
import alancasasarevalo.com.repository.buildDBHelper
import alancasasarevalo.com.repository.dao.ActivityDAO
import alancasasarevalo.com.repository.model.ActivityEntity
import alancasasarevalo.com.repository.network.DispatchOnMainThread
import android.content.Context
import java.lang.ref.WeakReference

class CacheActivityImplementation(context: Context): CacheInterface<ActivityEntity>  {

    private val weakContext = WeakReference<Context>(context)

    override fun getAllElements(successCompletion: (elements: List<ActivityEntity>) -> Unit, errorCompletion: (errorMessage: String) -> Unit) {
        Thread(Runnable {

            var activities = ActivityDAO(cacheDBHelper()).queryListElement()

            DispatchOnMainThread(Runnable {
                if (activities.count() > 0){
                    successCompletion(activities)
                }else{
                    errorCompletion("Error to query activities")
                }
            })

        }).run()
    }

    override fun saveAllElements(elements: List<ActivityEntity>, successCompletion: () -> Unit, errorCompletion: (errorMessage: String) -> Unit) {
        Thread(Runnable {

            try {
                elements.forEach{ ActivityDAO(cacheDBHelper()).insertElement(it) }
                DispatchOnMainThread(Runnable{
                    successCompletion()
                })

            }catch(e: Exception){
                DispatchOnMainThread(Runnable {
                    errorCompletion("Error inserting activities")
                })
            }

        }).run()    }

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