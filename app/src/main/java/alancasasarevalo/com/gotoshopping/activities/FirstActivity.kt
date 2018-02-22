package alancasasarevalo.com.gotoshopping.activities

import alancasasarevalo.com.domain.interactor.ErrorCompletion
import alancasasarevalo.com.domain.interactor.SuccessCompletion
import alancasasarevalo.com.domain.interactor.getallinteractor.GenericGetAllElementsInteractorImplementation
import alancasasarevalo.com.domain.models.MadridActivities
import alancasasarevalo.com.domain.models.Shops
import alancasasarevalo.com.gotoshopping.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {

    lateinit var shops:Shops
    lateinit var activities:MadridActivities

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        setupMap()
    }

    fun setupMap() {

        val genericAllElementsImplementation = GenericGetAllElementsInteractorImplementation(this)

        genericAllElementsImplementation.execute(
                object : SuccessCompletion<Shops?, MadridActivities?>{
                    override fun successCompletion(elementsT: Shops?, elementsZ: MadridActivities?) {
                        if (elementsT != null && elementsZ != null){
                            shops = elementsT
                            activities = elementsZ
                            startActivity(MainActivity.intent(baseContext, shops, activities))
                        }
                    }
                },
                object : ErrorCompletion{
                    override fun errorCompletion(errorMessage: String) {
                    }
                })
    }
}
