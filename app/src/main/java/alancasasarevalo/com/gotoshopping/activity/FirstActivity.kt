package alancasasarevalo.com.gotoshopping.activity

import alancasasarevalo.com.domain.interactor.ErrorCompletion
import alancasasarevalo.com.domain.interactor.SuccessCompletion
import alancasasarevalo.com.domain.interactor.getallinteractor.GenericGetAllElementsInteractorImplementation
import alancasasarevalo.com.domain.models.MadridActivities
import alancasasarevalo.com.domain.models.Shops
import alancasasarevalo.com.gotoshopping.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

//TODO: Eliminar los log

class FirstActivity : AppCompatActivity() {


    var shops:Shops? = null
    var activities:MadridActivities? = null

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

                            //TODO: ver donde esta fallando la llamada a actividades
                            activities?.activities?.forEach{
                                Log.d("Activity name", "${it.name}")
                            }
                            //TODO: Hacer que se pasen las acticidades y las tiendas cuando se acaben de cargar todas.
                            //TODO: el intent esta mal hecho, porque this no funciona dentro del objeto ya que referencia al objeto.
//                            startActivity(MainActivity.intent(FirstActivity().baseContext, shops, activities))
                        }
                    }
                },
                object : ErrorCompletion{
                    override fun errorCompletion(errorMessage: String) {
                    }
                })
    }
}
