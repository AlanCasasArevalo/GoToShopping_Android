package alancasasarevalo.com.repository

import android.support.test.InstrumentationRegistry
import junit.framework.Assert
import org.junit.Test

class VolleyNetworkTest {
    val appContext = InstrumentationRegistry.getContext()

    @Test
    @Throws(Exception::class)
    fun given_valid_url_when_we_get_non_null_json_as_sttring_then_url_is_correct() {
        val url = "http://madrid-shops.com/json_new/getShops.php"

        val jsonManager: GetJsonManagerInterface = GetJsonManagerVolley(appContext)

        jsonManager.execute(url, object : SuccessCompletion<String>{
            override fun successCompletion(element: String) {
                Assert.assertTrue(element.isNotEmpty())
            }

        }, object : ErrorCompletion{
            override fun errorCompletion(errorMessage: String) {
                Assert.assertTrue(false)
            }
        })

    }
}