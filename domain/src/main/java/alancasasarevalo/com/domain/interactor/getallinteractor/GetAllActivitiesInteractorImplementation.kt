package alancasasarevalo.com.domain.interactor.getallinteractor

import android.content.Context

class GetAllActivitiesInteractorImplementation (context: Context) {
//class GetAllActivitiesInteractorImplementation (context: Context) : GetAllElementInteractor {

//    val weakReference = WeakReference(context)
//    private var repository : RepositoryInterface<ActivityEntity> = ActivityRepositoryImplementation(weakReference.get()!!)
//
//    override fun execute(successShops: SuccessCompletion<Shops>?, successActivities: SuccessCompletion<MadridActivities>?, error: ErrorCompletion) {
//        repository.getAllElements(successCompletion = {
//            val madridActivities: MadridActivities = entityMapper(it)
//            successActivities?.successCompletion(madridActivities)
//        }, errorCompletion = {
//            kotlin.error(it)
//        })
//    }
//
//    override fun execute(successShops: SuccessCompletion<Shops?, MadridActivities?>, error: ErrorCompletion) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//
//    private fun entityMapper(list : List<ActivityEntity>): MadridActivities {
//
//        val tempList = ArrayList<MadridActivity>()
//
//        list.forEach{
//
//            val activity = MadridActivity(it.id.toInt(),
//                    "",
//                    it.img,
//                    it.logoImg,
//                    it.address,
//                    it.url,
//                    it.telephone,
//                    it.email,
//                    it.specialOffer.toBoolean(),
//                    it.description,
//                    it.latitude,
//                    it.longitude,
//                    it.openingHours,
//                    it.keywords
//            )
//
//
//            tempList.add(activity)
//        }
//
//        val activities = MadridActivities(tempList)
//        return  activities
//    }
}