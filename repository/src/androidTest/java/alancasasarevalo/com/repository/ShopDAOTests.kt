package alancasasarevalo.com.repository

import alancasasarevalo.com.repository.dao.ShopDAO
import alancasasarevalo.com.repository.dao.ShopEntity
import android.support.test.InstrumentationRegistry
import android.util.Log
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

class ShopsModelTest {

    val appContext = InstrumentationRegistry.getTargetContext()
    internal val dbhelper = buildDBHelper(appContext, "mydb.sqlite",1)

    internal val shopEntityDAO = ShopDAO(dbhelper)

    val shop1 = ShopEntity(1,
            1,
            "Shop1",
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

    val shop2 = ShopEntity(2,
            2,
            "Shop2",
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
        assertEquals(0, convertBooleanToInt(false))
    }

    @Test
    @Throws(Exception::class)
    fun given_value_1_when_compare_to_true_this_is_true() {
        assertEquals(0, convertBooleanToInt(false))
    }

    @Test
    @Throws(Exception::class)
    fun given_shop_when_insert_shop_then_it_gets_inserted_correctly() {
        shopEntityDAO.deleteAllElementList()
        val id = shopEntityDAO.insertElement(shop1)
        assertTrue(id > 1)
    }

    @Test
    @Throws(Exception::class)
    fun given_shopDAO_when_queryWithId_then_it_return_a_shopEntity() {
        shopEntityDAO.deleteAllElementList()
        val id = shopEntityDAO.insertElement(shop1)
        shopEntityDAO.insertElement(shop2)
        shopEntityDAO.queryListElement().forEach{
            Log.d("Shops", "${it.name}, ${it.id}")
        }
    }

}