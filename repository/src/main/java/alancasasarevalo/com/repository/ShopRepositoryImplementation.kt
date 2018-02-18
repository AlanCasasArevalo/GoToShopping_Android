package alancasasarevalo.com.repository

import alancasasarevalo.com.repository.cache.CacheInterface
import alancasasarevalo.com.repository.cache.CacheShopImplementation
import alancasasarevalo.com.repository.model.ShopEntity
import alancasasarevalo.com.repository.model.ShopsResponseEntity
import alancasasarevalo.com.repository.network.GetJsonManagerInterface
import alancasasarevalo.com.repository.network.GetJsonManagerVolley
import alancasasarevalo.com.repository.network.json.JsonEntitiesParser
import android.content.Context
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import java.lang.ref.WeakReference

class ShopRepositoryImplementation (context: Context): RepositoryInterface<ShopEntity>{

        private val weakContext = WeakReference<Context>(context)
        private val cache: CacheInterface<ShopEntity> = CacheShopImplementation(weakContext.get()!!)

        override fun getAllElements(successCompletion: (element: List<ShopEntity>) -> Unit, errorCompletion: (errorMessage: String) -> Unit) {
            cache.getAllElements({
                successCompletion(it)
            },{
                errorCompletion
            })
        }

        override fun deleteAllElements(successCompletion: () -> Unit, errorCompletion: (errorMessage: String) -> Unit) {
            cache.deleteAllElements(successCompletion, errorCompletion)
        }


        private fun populateCache(successCompletion: (element: List<ShopEntity>) -> Unit, errorCompletion: (errorMessage: String) -> Unit) {

            val jsonManager: GetJsonManagerInterface = GetJsonManagerVolley(weakContext.get()!!)

            jsonManager.execute(BuildConfig.MADRID_SHOPS_SERVER_URL, successCompletion = object : SuccessCompletion<String>{
                override fun successCompletion(element: String) {
                    //perform network request
                    val parser = JsonEntitiesParser()

                    var responseEntity: ShopsResponseEntity
                    responseEntity = try {
                        parser.parse<ShopsResponseEntity>(element)
                    } catch (e: InvalidFormatException) {
                        error("ERROR PARSING")
                        return
                    }

                    //store result in cache
                    cache.saveAllElements(responseEntity.result, successCompletion = {
                        successCompletion(responseEntity.result)
                    }, errorCompletion = {
                        errorCompletion("Something happened on the way to heaven!!!!")
                    })

                }
            }, errorCompletion = object : ErrorCompletion{
                override fun errorCompletion(errorMessage: String) {

                }
            })

        }

    }