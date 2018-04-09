package alancasasarevalo.com.gotoshopping.activity

import alancasasarevalo.com.domain.interactor.ErrorCompletion
import alancasasarevalo.com.domain.interactor.SuccessCompletion
import alancasasarevalo.com.domain.interactor.getallinteractor.GenericGetAllElementsInteractorImplementation
import alancasasarevalo.com.domain.interactor.getallinteractor.GetAllElementInteractor
import alancasasarevalo.com.domain.models.MadridActivities
import alancasasarevalo.com.domain.models.Shops
import alancasasarevalo.com.gotoshopping.R
import alancasasarevalo.com.gotoshopping.R.id.shops
import alancasasarevalo.com.gotoshopping.fragment.MapFragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var shops : Shops
    lateinit var activities : MadridActivities

    var mapFragment: MapFragment? = null
    var listFragment: ListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        listFragment = supportFragmentManager.findFragmentById(R.id.activity_main_list_fragment) as ListFragment

        setupMap()

    }

    fun setupMap(){
        mapFragment = supportFragmentManager.findFragmentById(R.id.activity_main_map_fragment) as MapFragment
        val mapFragmentInmutable = mapFragment

        var genericAllElementsImplementation: GetAllElementInteractor = GenericGetAllElementsInteractorImplementation(this)
        genericAllElementsImplementation.execute(
                object : SuccessCompletion<Shops?, MadridActivities?> {
                    override fun successCompletion(elementsT: Shops?, elementsZ: MadridActivities?) {
                        if (elementsT != null && elementsZ != null){

                            // TODO: Mirar porque estan cambiadas actividades y shops.
                            shops = elementsT
                            activities = elementsZ
                            mapFragmentInmutable?.setShops(shops)
                            mapFragmentInmutable?.setActivities(activities)
                        }
                    }
                },
                object : ErrorCompletion {
                    override fun errorCompletion(errorMessage: String) {
                        Toast.makeText(baseContext, errorMessage, Toast.LENGTH_LONG).show()
                    }
                })
    }

}
























