package alancasasarevalo.com.gotoshopping

import alancasasarevalo.com.domain.interactor.ErrorCompletion
import alancasasarevalo.com.domain.interactor.SuccessCompletion
import alancasasarevalo.com.domain.interactor.getallinteractor.GetAllActivitiesInteractorImplementation
import alancasasarevalo.com.domain.interactor.getallinteractor.GetAllShopsInteractorImplementation
import alancasasarevalo.com.domain.models.MadridActivities
import alancasasarevalo.com.domain.models.Shops
import android.support.multidex.MultiDexApplication
import android.util.Log

class MadridGoToShoppingApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        val allActivitiesInteractor = GetAllActivitiesInteractorImplementation(this)

        val allShopsInteractor = GetAllShopsInteractorImplementation(this)

        allShopsInteractor.execute(object : SuccessCompletion<Shops> {
            override fun successCompletion(elements: Shops) {
                Log.d("SHOPS COUNT", "elements.getCountElementList() ${elements.getCountElementList()}")
            }

        }, null,

                object : ErrorCompletion {
                    override fun errorCompletion(errorMessage: String) {
                    }
                })

        allActivitiesInteractor.execute(null, object : SuccessCompletion<MadridActivities> {
            override fun successCompletion(elements: MadridActivities) {
                Log.d("ACTIVITIES COUNT", "elements.getCountElementList() ${elements.getCountElementList()}")
            }

        }, object : ErrorCompletion {
            override fun errorCompletion(errorMessage: String) {
            }
        })

//        DeleteAllShopsImplementation(this).execute({
//            Log.d("Success", "Base de datos borrada")
//        },{
//            Log.d("Error al borrar", "El error fue $it")
//        })

    }

    override fun onLowMemory() {
        super.onLowMemory()

    }
}


