package alancasasarevalo.com.repository

import alancasasarevalo.com.repository.cache.GenericCacheImplementation
import alancasasarevalo.com.repository.model.ActivitiesResponseEntity
import alancasasarevalo.com.repository.model.ActivityEntity
import alancasasarevalo.com.repository.model.ShopEntity
import alancasasarevalo.com.repository.model.ShopsResponseEntity
import alancasasarevalo.com.repository.network.GenericGetJsonManagerInterface
import alancasasarevalo.com.repository.network.GenericGetJsonManagerVolley
import alancasasarevalo.com.repository.network.json.JsonEntitiesParser
import android.content.Context
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import java.lang.ref.WeakReference

class GenericRepositoryImplementation(context: Context) : GenericRepositoryInterface<ShopEntity, ActivityEntity> {

    private val weakContext = WeakReference<Context>(context)
    private val cache: GenericCacheImplementation = GenericCacheImplementation(weakContext.get()!!)

    override fun getAllElements(successCompletionElementT: (element: List<ShopEntity>, List<ActivityEntity>) -> Unit, errorCompletion: (errorMessage: String) -> Unit) {
        cache.getAllElements({ shopsEntity, activitiesEntity ->
            successCompletionElementT(shopsEntity, activitiesEntity)
        }, {
            populateCache(successCompletionElementT, errorCompletion)
        })
    }

    override fun deleteAllElements(successCompletionElementT: () -> Unit, successCompletionElementZ: () -> Unit, errorCompletion: (errorMessage: String) -> Unit) {
        cache.deleteAllElements(successCompletionElementT, successCompletionElementZ, errorCompletion)
    }

    private fun populateCache(successCompletion: (element: List<ShopEntity>, List<ActivityEntity>) -> Unit, errorCompletion: (errorMessage: String) -> Unit) {

        val jsonManager: GenericGetJsonManagerInterface = GenericGetJsonManagerVolley(weakContext.get()!!)

        jsonManager.execute(BuildConfig.MADRID_SHOPS_SERVER_URL, BuildConfig.MADRID_ACTIVITY_SERVER_URL, object : SuccessCompletion<String> {
            override fun successCompletion(elements: String) {
                val parser = JsonEntitiesParser()

                var responseShopsEntity: ShopsResponseEntity
                var responseActivitiesEntity: ActivitiesResponseEntity

                responseShopsEntity = try {
                    parser.parse<ShopsResponseEntity>(elements)
                } catch (e: InvalidFormatException) {
                    error("ERROR PARSING")
                    return
                }
                responseActivitiesEntity = try {
                    parser.parse<ActivitiesResponseEntity>(elements)
                } catch (e: InvalidFormatException) {
                    error("ERROR PARSING")
                    return
                }

                //store result in cache
                cache.saveAllElements(responseShopsEntity.result, responseActivitiesEntity.result, successCompletion = {
                    successCompletion(responseShopsEntity.result, responseActivitiesEntity.result)
                },errorCompletion = {
                    errorCompletion("Something happened on the way to heaven!!!! $it")
                })

            }
        }, object : ErrorCompletion {
            override fun errorCompletion(errorMessage: String) {
            }

        })

    }

}


























