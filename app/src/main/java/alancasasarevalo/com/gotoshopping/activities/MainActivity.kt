package alancasasarevalo.com.gotoshopping.activities

import alancasasarevalo.com.domain.models.MadridActivities
import alancasasarevalo.com.domain.models.Shops
import alancasasarevalo.com.gotoshopping.R
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var shops : Shops
    lateinit var activities : MadridActivities

    companion object {
        val EXTRA_SHOPS = "EXTRA_SHOPS"
        val EXTRA_ACTIVITIES = "EXTRA_ACTIVITIES"

        fun intent (context: Context, shops: Shops?, madridActivities: MadridActivities?) : Intent{
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(EXTRA_SHOPS, shops)
            intent.putExtra(EXTRA_ACTIVITIES, madridActivities)

            return intent
        }

    }

//TODO: Implementar todos los fragments UI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shops = (intent.getParcelableExtra(EXTRA_SHOPS) as? Shops)!!
        activities = (intent.getParcelableExtra(EXTRA_ACTIVITIES) as? MadridActivities)!!

    }
}
