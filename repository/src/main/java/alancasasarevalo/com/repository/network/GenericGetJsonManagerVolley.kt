package alancasasarevalo.com.repository.network

import alancasasarevalo.com.repository.ErrorCompletion
import alancasasarevalo.com.repository.SuccessCompletion
import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.lang.ref.WeakReference

class GenericGetJsonManagerVolley (context: Context): GenericGetJsonManagerInterface {

    private var weakContext: WeakReference<Context> = WeakReference(context)
    private var requestQueue: RequestQueue? = null

    override fun execute(urlT: String, urlZ: String, successCompletion: SuccessCompletion<String>, errorCompletion: ErrorCompletion) {

        val requestT = StringRequest(urlT, Response.Listener {

            successCompletion.successCompletion(it)

        }, Response.ErrorListener {
            errorCompletion.errorCompletion(it.localizedMessage)
        })
        val requestZ = StringRequest(urlZ, Response.Listener {
            successCompletion.successCompletion(it)
        }, Response.ErrorListener {
            errorCompletion.errorCompletion(it.localizedMessage)
        })

        requestQueue().add(requestT)
        requestQueue().add(requestZ)
    }

    private fun requestQueue(): RequestQueue {

        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(weakContext.get())
        }
        return requestQueue!!
    }

}
