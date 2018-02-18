package alancasasarevalo.com.repository.cache

import alancasasarevalo.com.repository.DBHelper
import alancasasarevalo.com.repository.buildDBHelper
import alancasasarevalo.com.repository.dao.ActivityDAO
import alancasasarevalo.com.repository.model.ShopEntity
import alancasasarevalo.com.repository.network.DispatchOnMainThread
import android.content.Context
import java.lang.ref.WeakReference

class CacheShopImplementation(context: Context): CacheInterface<ShopEntity>  {

    private val weakContext = WeakReference<Context>(context)

    override fun getAllElements(successCompletion: (elements: List<ShopEntity>) -> Unit, errorCompletion: (errorMessage: String) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveAllElements(elements: List<ShopEntity>, successCompletion: () -> Unit, errorCompletion: (errorMessage: String) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAllElements(successCompletion: () -> Unit, errorCompletion: (errorMessage: String) -> Unit) {
        Thread(Runnable {
            var successDeleting = ActivityDAO(cacheDBHelper("MadridShops.sqlite")).deleteAllElementList()

            DispatchOnMainThread(Runnable {
                if (successDeleting){
                    successCompletion()
                }else{
                    errorCompletion("Error deleting")
                }
            })

        }).run()
    }


    private fun cacheDBHelper(name: String): DBHelper {
        return  buildDBHelper(weakContext.get()!!, name, 1)
    }

}