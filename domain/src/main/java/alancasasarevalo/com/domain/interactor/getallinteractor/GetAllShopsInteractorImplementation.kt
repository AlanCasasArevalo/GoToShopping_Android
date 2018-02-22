package alancasasarevalo.com.domain.interactor.getallinteractor

import android.content.Context

class GetAllShopsInteractorImplementation (context: Context)  {
//class GetAllShopsInteractorImplementation (context: Context) : GetAllElementInteractor {
//
//    val weakReference = WeakReference(context)
//    private var repository : RepositoryInterface <ShopEntity> = ShopRepositoryImplementation(weakReference.get()!!)
//
//    override fun execute(successShops: SuccessCompletion<Shops>?, successActivities: SuccessCompletion<MadridActivities>?, error: ErrorCompletion) {
//        repository.getAllElements(successCompletion = {
//            val shops:Shops = entityMapper(it)
//            successShops?.successCompletion(shops)
//        }, errorCompletion = {
//            kotlin.error(it)
//        })
//    }
//
//    private fun entityMapper(list : List<ShopEntity>): Shops{
//
//        val tempList = ArrayList<Shop>()
//
//        list.forEach{
//
//            val shop = Shop(it.id.toInt(),
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
//            tempList.add(shop)
//        }
//
//        val shops = Shops(tempList)
//        return  shops
//    }
}