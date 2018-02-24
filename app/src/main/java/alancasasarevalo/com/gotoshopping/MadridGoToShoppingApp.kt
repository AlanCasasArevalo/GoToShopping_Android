package alancasasarevalo.com.gotoshopping

import alancasasarevalo.com.domain.models.MadridActivities
import alancasasarevalo.com.domain.models.Shops
import android.support.multidex.MultiDexApplication

class MadridGoToShoppingApp : MultiDexApplication() {

    lateinit var shops : Shops
    lateinit var activities : MadridActivities

    override fun onCreate() {
        super.onCreate()

//        val genericAllElementsImplementation = GenericGetAllElementsInteractorImplementation(this)
//
//        genericAllElementsImplementation.execute(
//                object : SuccessCompletion<Shops?, MadridActivities?> {
//                    override fun successCompletion(elementsT: Shops?, elementsZ: MadridActivities?) {
//                        if (elementsT != null && elementsZ != null){
//                            shops = elementsT
//                            activities = elementsZ
//                            startActivity(MainActivity.intent(baseContext, shops, activities))
//                        }
//                    }
//                },
//                object : ErrorCompletion {
//                    override fun errorCompletion(errorMessage: String) {
//                    }
//                })
//


    }

    override fun onLowMemory() {
        super.onLowMemory()

    }
}

















