package alancasasarevalo.com.gotoshopping.activity

import alancasasarevalo.com.domain.models.MadridActivities
import alancasasarevalo.com.domain.models.Shops
import alancasasarevalo.com.gotoshopping.ActivitiesFragment
import alancasasarevalo.com.gotoshopping.R
import alancasasarevalo.com.gotoshopping.ShopsFragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var shops: Shops
    lateinit var activities: MadridActivities

    private val fragments: HashMap<Int, Fragment> = hashMapOf(
            Pair(R.id.shops, ShopsFragment()),
            Pair(R.id.activities, ActivitiesFragment())
    )

    companion object {
        const val EXTRA_SHOPS = "EXTRA_SHOPS"
        const val EXTRA_ACTIVITIES = "EXTRA_ACTIVITIES"
        const val DEFAULT_OPTION_SELECTED = R.id.shops

        fun intent(context: Context, shops: Shops?, madridActivities: MadridActivities?): Intent {
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


        navigation_view.selectedItemId = DEFAULT_OPTION_SELECTED
        navigation_view.setOnNavigationItemSelectedListener { item ->
            val fragment: Fragment? = fragments[item.itemId]

            if (fragment != null) {
                replaceErrorFragment(fragment)
            }

            true
        }

    }

    private fun replaceErrorFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
    }

    private fun initViewWithDefaultFragment() {
        val currentFragment = supportFragmentManager
                .findFragmentById(R.id.fragment_container)

        if (currentFragment == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, fragments[DEFAULT_OPTION_SELECTED])
                    .commit()
        }
    }
}
























