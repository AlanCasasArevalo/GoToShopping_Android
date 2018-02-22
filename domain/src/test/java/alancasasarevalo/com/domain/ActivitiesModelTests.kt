package alancasasarevalo.com.domain

import alancasasarevalo.com.domain.models.MadridActivities
import alancasasarevalo.com.domain.models.MadridActivity
import junit.framework.Assert
import junit.framework.Assert.assertNotNull
import org.junit.Test

class ActivitiesModelTests {

    val sut = MadridActivities(arrayListOf())

    val activity = MadridActivity(1,
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
    fun given_activities_when_we_try_to_access_to_activities_model_existence() {
        assertNotNull(sut)
    }

    @Test
    @Throws(Exception::class)
    fun given_activity_then_when_add_activity_then_we_added_a_activity() {

        Assert.assertEquals(0, sut.getCountElementList())

        sut.addNewElement(activity)
        Assert.assertEquals(1, sut.getCountElementList())

    }

    @Test
    @Throws(Exception::class)
    fun given_activity_when_we_delete_activity_then_we_delete_a_activity() {

        Assert.assertEquals(0, sut.getCountElementList())

        sut.addNewElement(activity)
        sut.addNewElement(activity)
        Assert.assertEquals(2, sut.getCountElementList())

        sut.delete(activity)
        Assert.assertEquals(1, sut.getCountElementList())
    }

    @Test
    @Throws(Exception::class)
    fun given_activity_when_we_delete_activity_by_position_then_we_delete_a_activity() {

        Assert.assertEquals(0, sut.getCountElementList())

        sut.addNewElement(activity)
        sut.addNewElement(activity)
        Assert.assertEquals(2, sut.getCountElementList())

        sut.deleteElementByPosition(1)
        Assert.assertEquals(1, sut.getCountElementList())
    }

}