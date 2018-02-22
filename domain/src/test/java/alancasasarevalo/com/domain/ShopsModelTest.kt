package alancasasarevalo.com.domain

import alancasasarevalo.com.domain.models.Shop
import alancasasarevalo.com.domain.models.Shops
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test

class ShopsModelTest {

    val sut = Shops(arrayListOf())
    val shop = Shop(1,
            "Cortefiel - Preciados",
            "https://madrid-shops.com/media/shops/logoImg-cortefiel-200.jpg",
            "https://madrid-shops.com/media/shops/logoImg-cortefiel-200.jpg",
            "Puerta del Sol 11",
            "www.grupocortefiel.com",
            "(34) 91 522 64 31",
            "",
            false,
            "An extensive network of stores spread across four continents makes Cortefiel Group one of the leading European companies in the fashion industry.  Through its four chains -Cortefiel, Pedro del Hierro, Springfield and Women'secret-, the Group operates in 58 countries with 1,647 points of sale. ",
            "40.4180563",
            "-3.7010172999999895",
            "Monday to Saturday: 10: 00-21: 00",
            "none"
    )



    @Test
    @Throws(Exception::class)
    fun given_shops_when_we_try_to_access_shops_model_existence() {
        assertNotNull(sut)
    }

    @Test
    @Throws(Exception::class)
    fun given_shop_then_when_add_shop_then_we_added_a_shop() {

        assertEquals(0, sut.getCountElementList())

        sut.addNewElement(shop)
        assertEquals(1, sut.getCountElementList())

    }

    @Test
    @Throws(Exception::class)
    fun given_shop_when_we_delete_shop_then_we_delete_a_shop() {

        assertEquals(0, sut.getCountElementList())

        sut.addNewElement(shop)
        sut.addNewElement(shop)
        assertEquals(2, sut.getCountElementList())

        sut.delete(shop)
        assertEquals(1, sut.getCountElementList())
    }

    @Test
    @Throws(Exception::class)
    fun given_shop_when_we_delete_shop_by_position_then_we_delete_a_shop() {

        assertEquals(0, sut.getCountElementList())

        sut.addNewElement(shop)
        sut.addNewElement(shop)
        assertEquals(2, sut.getCountElementList())

        sut.deleteElementByPosition(1)
        assertEquals(1, sut.getCountElementList())
    }






}