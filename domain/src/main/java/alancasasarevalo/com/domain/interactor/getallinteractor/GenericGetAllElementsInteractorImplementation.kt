package alancasasarevalo.com.domain.interactor.getallinteractor

import alancasasarevalo.com.domain.interactor.ErrorCompletion
import alancasasarevalo.com.domain.interactor.SuccessCompletion
import alancasasarevalo.com.domain.models.MadridActivities
import alancasasarevalo.com.domain.models.MadridActivity
import alancasasarevalo.com.domain.models.Shop
import alancasasarevalo.com.domain.models.Shops
import alancasasarevalo.com.repository.GenericRepositoryImplementation
import alancasasarevalo.com.repository.GenericRepositoryInterface
import alancasasarevalo.com.repository.model.ActivityEntity
import alancasasarevalo.com.repository.model.ShopEntity
import android.content.Context
import android.util.Log
import java.lang.ref.WeakReference

//TODO: eliminar los Logs comentados
class GenericGetAllElementsInteractorImplementation(context: Context) : GetAllElementInteractor {
    private val weakReference = WeakReference(context)
    private var repository: GenericRepositoryInterface<ShopEntity, ActivityEntity> = GenericRepositoryImplementation(weakReference.get()!!)

    override fun execute(success: SuccessCompletion<Shops?, MadridActivities?>, error: ErrorCompletion) {
        repository.getAllElements(successCompletionElementT = { shopEntities: List<ShopEntity>, activityEntities: List<ActivityEntity> ->
            val shops: Shops = entityShopsMapper(shopEntities)
            val activities: MadridActivities = entityActivitiesMapper(activityEntities)

            success.successCompletion(shops, activities)
        }, errorCompletion = {
            Log.d("Error","Error to get all elements from repository $it")
        })

    }

    private fun entityShopsMapper(list: List<ShopEntity>): Shops {

        val tempShopList = ArrayList<Shop>()

        list.forEach {

            val shop = Shop(it.id.toInt(),
                    it.name,
                    it.img,
                    it.logoImg,
                    it.address,
                    it.url,
                    it.telephone,
                    it.email,
                    it.specialOffer.toBoolean(),
                    it.description,
                    getCorrectCoordinateComponent(it.latitude),
                    getCorrectCoordinateComponent(it.longitude),
                    it.openingHours,
                    it.keywords
            )

            tempShopList.add(shop)
        }

        val shops = Shops(tempShopList)

        return shops
    }


    private fun entityActivitiesMapper(list: List<ActivityEntity>): MadridActivities {

        val tempActivitiesList = ArrayList<MadridActivity>()

        list.forEach {

            val activity = MadridActivity(it.id.toInt(),
                    it.name,
                    it.img,
                    it.logoImg,
                    it.address,
                    it.url,
                    it.telephone,
                    it.email,
                    it.specialOffer.toBoolean(),
                    it.description,
                    getCorrectCoordinateComponent(it.latitude),
                    getCorrectCoordinateComponent(it.longitude),
                    it.openingHours,
                    it.keywords
            )

            tempActivitiesList.add(activity)
        }

        val activities = MadridActivities(tempActivitiesList)

        return activities
    }

    private fun getCorrectCoordinateComponent(coordinateComponent: String): String {
        var coordinate = 0.0f
        val s = coordinateComponent.replace(",", "")
        try {
            coordinate = java.lang.Float.parseFloat(s)
        } catch (e: Exception) {
            Log.d("ERROR CONVERTING", String.format("Can't convert %s", coordinateComponent))
        }
        return coordinate.toString()
    }

}


































