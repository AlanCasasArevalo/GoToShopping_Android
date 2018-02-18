package alancasasarevalo.com.repository

import alancasasarevalo.com.repository.cache.CacheActivityImplementation
import alancasasarevalo.com.repository.cache.CacheInterface
import alancasasarevalo.com.repository.model.ActivitiesResponseEntity
import alancasasarevalo.com.repository.model.ActivityEntity
import alancasasarevalo.com.repository.network.GetJsonManagerInterface
import alancasasarevalo.com.repository.network.GetJsonManagerVolley
import alancasasarevalo.com.repository.network.json.JsonEntitiesParser
import android.content.Context
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import java.lang.ref.WeakReference

class ActivityRepositoryImplementation (context: Context): RepositoryInterface<ActivityEntity>{

    private val weakContext = WeakReference<Context>(context)
    private val cache: CacheInterface<ActivityEntity> = CacheActivityImplementation(weakContext.get()!!)


    override fun getAllElements(successCompletion: (element: List<ActivityEntity>) -> Unit, errorCompletion: (errorMessage: String) -> Unit) {
        cache.getAllElements({
            successCompletion(it)
        },{
            errorCompletion
        })
    }

    override fun deleteAllElements(successCompletion: () -> Unit, errorCompletion: (errorMessage: String) -> Unit) {
        cache.deleteAllElements(successCompletion, errorCompletion)
    }


    private fun populateCache(successCompletion: (element: List<ActivityEntity>) -> Unit, errorCompletion: (errorMessage: String) -> Unit) {

        val jsonManager: GetJsonManagerInterface = GetJsonManagerVolley(weakContext.get()!!)

        jsonManager.execute(BuildConfig.MADRID_ACTIVITY_SERVER_URL, successCompletion = object : SuccessCompletion<String>{
            override fun successCompletion(element: String) {
                //perform network request
                val parser = JsonEntitiesParser()

                var responseEntity: ActivitiesResponseEntity
                responseEntity = try {
                    parser.parse<ActivitiesResponseEntity>(element)
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