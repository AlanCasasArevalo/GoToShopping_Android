package alancasasarevalo.com.gotoshopping.fragment


import alancasasarevalo.com.domain.models.MadridActivities
import alancasasarevalo.com.domain.models.Shops
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import alancasasarevalo.com.gotoshopping.R
import alancasasarevalo.com.gotoshopping.R.id.shops
import android.util.Log


/**
 * A simple [Fragment] subclass.
 */
class MapFragment : Fragment() {


    fun setShops(shops: Shops){
        Log.d("ShopsENMAPA", "Tiendas en el mapa ${shops.shops.count()}")
    }

    fun setActivities(activities: MadridActivities){
        Log.d("ActivitiesENMAPA", "Actividades en el mapa ${activities.activities.count()}")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_map, container, false)
    }

}// Required empty public constructor
