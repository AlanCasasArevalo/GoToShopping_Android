package alancasasarevalo.com.domain.interactor.getallinteractor

import alancasasarevalo.com.domain.interactor.ErrorCompletion
import alancasasarevalo.com.domain.interactor.SuccessCompletion
import alancasasarevalo.com.domain.models.MadridActivities
import alancasasarevalo.com.domain.models.MadridActivity
import alancasasarevalo.com.domain.models.Shop
import alancasasarevalo.com.domain.models.Shops

class GetAllElementsInteractorFakeImplementation : GetAllElementInteractor {
    override fun execute(successShops: SuccessCompletion<Shops>?, successActivities: SuccessCompletion<MadridActivities>?, error: ErrorCompletion) {

        var allOk = false

        // Connect to the repository

        if (allOk){
            val shops = createFakeListOfShops()
            val activities = createFakeListOfActivities()

            successShops?.successCompletion(shops as Shops)
            successActivities?.successCompletion(activities as MadridActivities)
        }else{
            error.errorCompletion("Error while accessing the RepositoryInterface")
        }

    }

    fun createFakeListOfActivities(): List<MadridActivity>{
        val list = ArrayList<MadridActivity>()

        (0..100).forEach { i ->
            val element = MadridActivity(1,
                    "Shop $i",
                    "http://madrid-shops.com/json_new/getShops.php",
                    "https://madrid-shops.com/media/shops/logo-cortefiel-200.jpg",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "",
                    "www.google.com",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "40.4180563",
                    "-3.7010172999999895",
                    false,
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i"
            )

            list.add(element)
        }

        return list
    }

    fun createFakeListOfShops(): List<Shop>{
        val list = ArrayList<Shop>()

        (0..100).forEach { i ->
            val element = Shop(1,
                    "Shop $i",
                    "http://madrid-shops.com/json_new/getShops.php",
                    "https://madrid-shops.com/media/shops/logo-cortefiel-200.jpg",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "",
                    "www.google.com",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "40.4180563",
                    "-3.7010172999999895",
                    false,
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i",
                    "Shop $i"
            )

            list.add(element)
        }

        return list
    }
}
























