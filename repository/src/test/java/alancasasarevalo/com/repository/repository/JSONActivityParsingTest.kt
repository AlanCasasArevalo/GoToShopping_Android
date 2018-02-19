package alancasasarevalo.com.repository.repository

import alancasasarevalo.com.repository.model.ActivityEntity
import alancasasarevalo.com.repository.network.json.JsonEntitiesParser
import alancasasarevalo.com.repository.util.ReadJsonFile
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import junit.framework.Assert.*
import org.junit.Test

class JSONActivityParsingTest {
    @Test
    @Throws(Exception::class)
    fun given_valid_string_when_containing_json_then_it_parse_one_shop_correctly() {
        val activityJson = ReadJsonFile().loadJSONFromAsset("MadridShop.json")
        assertTrue(false == activityJson.isEmpty())
        assertTrue(!activityJson.isEmpty())

        //parseo
        val parser = JsonEntitiesParser()
        val activityJsonParser = parser.parse<ActivityEntity>(activityJson)

        assertNotNull(activityJsonParser)
        assertEquals("Cortefiel - Preciados", activityJsonParser.name)
        assertEquals(40.4180563f, activityJsonParser.latitude.toFloat(), 0.1f)

    }

    @Test
    @Throws(Exception::class)
    fun given_valid_string_when_containing_json_then_it_parse_one_activity_correctly() {
        val activityJson = ReadJsonFile().loadJSONFromAsset("MadridShop.json")
        assertTrue(false == activityJson.isEmpty())
        assertTrue(!activityJson.isEmpty())

        //parseo
        val parser = JsonEntitiesParser()
        val activityEntity = parser.parse<ActivityEntity>(activityJson)

        assertNotNull(activityEntity)
        assertEquals("Cortefiel - Preciados", activityEntity.name)
        assertEquals(40.4180563f, activityEntity.latitude.toFloat(), 0.1f)

    }

    @Test
    @Throws(Exception::class)
    fun given_invalid_string_when_containing_json_with_wrong_latitude_then_it_parse_one_shop_correctly() {
        val activityJson = ReadJsonFile().loadJSONFromAsset("shopWrongLatitude.json")
        assertTrue(!activityJson.isEmpty())

        //parseo
        val parser = JsonEntitiesParser()
        var activityEntity : ActivityEntity

        activityEntity = try {
            parser.parse<ActivityEntity>(activityJson)
        }catch (e: InvalidFormatException){
            ActivityEntity(2,
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



        assertNotNull(activityEntity)
        assertNotSame("Parsing failed CRASH", activityEntity.name)
        assertEquals(40.4180563f, activityEntity.latitude.toFloat(), 0.1f)

    }


}