package alancasasarevalo.com.domain

import alancasasarevalo.com.domain.models.Shop
import junit.framework.Assert.*
import org.junit.Test

class ShopModelTests {
    @Test
    @Throws(Exception::class)
    fun given_shop_model_then_when_we_try_to_access_model_existence() {
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


        assertNotNull(shop)

        assertEquals(shop.name, "Cortefiel - Preciados")
        assertEquals(shop.id, 1)
        assertNotSame(shop.id, 2)
    }

}