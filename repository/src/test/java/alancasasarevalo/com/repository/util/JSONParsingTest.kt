package alancasasarevalo.com.repository.util

import alancasasarevalo.com.repository.model.ActivityEntity
import alancasasarevalo.com.repository.model.ShopEntity
import alancasasarevalo.com.repository.network.json.JsonEntitiesParser
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import junit.framework.Assert
import org.junit.Test

class JSONParsingTests {
    @Test
    @Throws(Exception::class)
    fun given_valid_string_when_containing_json_then_it_parse_one_shop_correctly() {
        val shopJson = ReadJsonFile().loadJSONFromAsset("MadridShop.json")
        Assert.assertTrue(false == shopJson.isEmpty())
        Assert.assertTrue(!shopJson.isEmpty())

        //parseo
        val parser = JsonEntitiesParser()
        val shop = parser.parse<ShopEntity>(shopJson)

        Assert.assertNotNull(shop)
        Assert.assertEquals("Cortefiel - Preciados", shop.name)
        Assert.assertEquals(40.4180563f, shop.latitude.toFloat(), 0.1f)

    }

    @Test
    @Throws(Exception::class)
    fun given_valid_string_when_containing_json_then_it_parse_one_activity_correctly() {
        val activityJson = ReadJsonFile().loadJSONFromAsset("MadridShop.json")
        Assert.assertTrue(false == activityJson.isEmpty())
        Assert.assertTrue(!activityJson.isEmpty())

        //parseo
        val parser = JsonEntitiesParser()
        val activityEntity = parser.parse<ActivityEntity>(activityJson)

        Assert.assertNotNull(activityEntity)
        Assert.assertEquals("Cortefiel - Preciados", activityEntity.name)
        Assert.assertEquals(40.4180563f, activityEntity.latitude.toFloat(), 0.1f)

    }

    @Test
    @Throws(Exception::class)
    fun given_invalid_string_when_containing_json_with_wrong_latitude_then_it_parse_one_shop_correctly() {
        val shopJson = ReadJsonFile().loadJSONFromAsset("shopWrongLatitude.json")
        Assert.assertTrue(!shopJson.isEmpty())

        //parseo
        val parser = JsonEntitiesParser()
        var shop : ShopEntity

        shop = try {
            parser.parse<ShopEntity>(shopJson)
        }catch (e: InvalidFormatException){
            ShopEntity(2,
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
        }

        Assert.assertNotNull(shop)
        Assert.assertEquals("Parsing failed CRASH", shop.name)
        Assert.assertEquals(40.4180563f, shop.latitude.toFloat(), 0.1f)

    }


}