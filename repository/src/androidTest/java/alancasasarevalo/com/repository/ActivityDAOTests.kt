package alancasasarevalo.com.repository

import alancasasarevalo.com.repository.dao.ActivityDAO
import alancasasarevalo.com.repository.dao.ActivityEntity
import android.support.test.InstrumentationRegistry
import android.util.Log
import junit.framework.Assert
import org.junit.Test

class ActivityDAOTests {

    val appContext = InstrumentationRegistry.getTargetContext()
    internal val dbhelper = buildDBHelper(appContext, "mydb.sqlite",1)

    internal val activityEntityDAO = ActivityDAO(dbhelper)

    val activity = ActivityEntity(1,
            1,
            "activity1 ",
            "",
            "",
            "",
            "sdfoi",
            "",
            "",
            "",
            "",
            "40.4180563",
            "-3.7010172999999895",
            "",
            ""
    )

    val activity2 = ActivityEntity(2,
            2,
            "activity 2",
            "",
            "",
            "",
            "sdfoi",
            "",
            "",
            "",
            "",
            "40.4180563",
            "-3.7010172999999895",
            "",
            ""
    )

    @Test
    @Throws(Exception::class)
    fun given_value_0_when_compare_to_false_this_is_true() {
        Assert.assertEquals(0, convertBooleanToInt(false))
    }

    @Test
    @Throws(Exception::class)
    fun given_value_1_when_compare_to_true_this_is_true() {
        Assert.assertEquals(0, convertBooleanToInt(false))
    }

    @Test
    @Throws(Exception::class)
    fun given_shop_when_insert_shop_then_it_gets_inserted_correctly() {
        activityEntityDAO.deleteAllElementList()
        val id = activityEntityDAO.insertElement(activity)
        Assert.assertTrue(id > 1)
    }

    @Test
    @Throws(Exception::class)
    fun given_shopDAO_when_queryWithId_then_it_return_a_shopEntity() {
        activityEntityDAO.deleteAllElementList()
        val id = activityEntityDAO.insertElement(activity)
        activityEntityDAO.insertElement(activity2)
        activityEntityDAO.queryListElement().forEach{
            Log.d("Shops", "${it.name}, ${it.id}")
        }
    }

}