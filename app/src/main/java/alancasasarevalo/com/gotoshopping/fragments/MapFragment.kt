package alancasasarevalo.com.gotoshopping.fragments


import alancasasarevalo.com.domain.interactor.getallinteractor.GetAllElementInteractor
import alancasasarevalo.com.domain.interactor.getallinteractor.GetAllShopsInteractorImplementation
import alancasasarevalo.com.gotoshopping.R
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 */
class MapFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_map, container, false)
    }

}