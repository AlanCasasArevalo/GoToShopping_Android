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
            "http://madrid-shops.com/json_new/getShops.php",
            "https://madrid-shops.com/media/shops/logo-cortefiel-200.jpg",
            "Monday to Saturday: 10: 00-21: 00",
            "De Lunes a Sábado: 10:00-21:00",
            "",
            "周二 - 周六：10:00-21:00",
            "De Lunes a Sábado: 10:00-21:00",
            "De Lunes a Sábado: 10:00-21:00",
            "(34) 91 522 64 31",
            "",
            "www.grupocortefiel.com",
            "Puerta del Sol 11",
            "An extensive network of stores spread across four continents makes Cortefiel Group one of the leading European companies in the fashion industry.  Through its four chains -Cortefiel, Pedro del Hierro, Springfield and Women'secret-, the Group operates in 58 countries with 1,647 points of sale. ",
            "Una extensa red de tiendas distribuidas por cuatro continentes convierte a Grupo Cortefiel en una de las principales compañías europeas del sector moda. A través de sus cuatro cadenas –Cortefiel, Pedro del Hierro, Springfield y Women’secret-, el Grupo está presente en 58 países con 1.647 puntos de venta.",
            "",
            "4大陸に店舗展開するCortefielグル－プは、ファッションの世界ではヨ－ロッパで主要なアパレルメ－カ－です。彼らの4つのブランド―Cortefiel、Pedro del Hierro、Springfield、Women’secret―は58カ国1647ヶ所で販売しています。",
            "Una extensa red de tiendas distribuidas por cuatro continentes convierte a Grupo Cortefiel en una de las principales compañías europeas del sector moda. A través de sus cuatro cadenas –Cortefiel, Pedro del Hierro, Springfield y Women’secret-, el Grupo está presente en 58 países con 1.647 puntos de venta.",
            "Una extensa red de tiendas distribuidas por cuatro continentes convierte a Grupo Cortefiel en una de las principales compañías europeas del sector moda. A través de sus cuatro cadenas –Cortefiel, Pedro del Hierro, Springfield y Women’secret-, el Grupo está presente en 58 países con 1.647 puntos de venta.",
            "40.4180563",
            "-3.7010172999999895",
            false,
            "Cortefiel, Springfield, Pedro del Hierro, Women's Secret",
            "Cortefiel, Springfield, Pedro del Hierro, Women’secret",
            "Cortefiel, Springfield, Pedro del Hierro, Women’secret",
            "Cortefie时装店l, Springfield时装店, Pedro del Hierro时装店, Women’secret内衣店",
            "Cortefiel, Springfield, Pedro del Hierro, Women’secret",
            "Cortefiel, Springfield, Pedro del Hierro, Women’secret",
            "none",
            ""
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