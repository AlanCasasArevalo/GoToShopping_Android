package alancasasarevalo.com.gotoshopping

import alancasasarevalo.com.domain.ErrorCompletion
import alancasasarevalo.com.domain.SuccessCompletion
import alancasasarevalo.com.domain.interactor.GetAllElementsInteractorFakeImplementation
import alancasasarevalo.com.domain.models.MadridActivities
import alancasasarevalo.com.domain.models.Shops
import android.support.multidex.MultiDexApplication
import android.util.Log

class MadridGoToShoppingApp: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        val allShopsInteractor = GetAllElementsInteractorFakeImplementation()

        allShopsInteractor.execute(object : SuccessCompletion<Shops> {
            override fun successCompletion(elements: Shops) {
                Log.d("SHOPS COUNT", "elements.getCountElementList() ${elements.getCountElementList()}")
            }

        }, object : SuccessCompletion<MadridActivities>{
            override fun successCompletion(elements: MadridActivities) {
                Log.d("ACTIVITIES COUNT", "elements.getCountElementList() ${elements.getCountElementList()}")
            }

        }, object: ErrorCompletion{
            override fun errorCompletion(errorMessage: String) {
            }
        })
    }

    override fun onLowMemory() {
        super.onLowMemory()

    }

}