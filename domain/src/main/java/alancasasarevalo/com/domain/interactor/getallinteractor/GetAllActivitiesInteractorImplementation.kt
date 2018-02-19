package alancasasarevalo.com.domain.interactor.getallinteractor

import alancasasarevalo.com.domain.interactor.ErrorCompletion
import alancasasarevalo.com.domain.interactor.SuccessCompletion
import alancasasarevalo.com.domain.models.MadridActivities
import alancasasarevalo.com.domain.models.MadridActivity
import alancasasarevalo.com.domain.models.Shops
import alancasasarevalo.com.repository.ActivityRepositoryImplementation
import alancasasarevalo.com.repository.RepositoryInterface
import alancasasarevalo.com.repository.model.ActivityEntity
import android.content.Context
import java.lang.ref.WeakReference

class GetAllActivitiesInteractorImplementation (context: Context) : GetAllElementInteractor {

    val weakReference = WeakReference(context)
    private var repository : RepositoryInterface<ActivityEntity> = ActivityRepositoryImplementation(weakReference.get()!!)

    override fun execute(successShops: SuccessCompletion<Shops>?, successActivities: SuccessCompletion<MadridActivities>?, error: ErrorCompletion) {
        repository.getAllElements(successCompletion = {
            val madridActivities: MadridActivities = entityMapper(it)
            successActivities?.successCompletion(madridActivities)
        }, errorCompletion = {
            kotlin.error(it)
        })
    }

    private fun entityMapper(list : List<ActivityEntity>): MadridActivities {

        val tempList = ArrayList<MadridActivity>()

        list.forEach{

            val activity = MadridActivity(it.id.toInt(),
                    "",
                    it.img,
                    it.logoImg,
                    it.address,
                    it.url,
                    it.telephone,
                    it.email,
                    it.specialOffer.toBoolean(),
                    it.description,
                    it.latitude,
                    it.longitude,
                    it.openingHours,
                    it.keywords
            )


            tempList.add(activity)
        }

        val activities = MadridActivities(tempList)
        return  activities
    }
}