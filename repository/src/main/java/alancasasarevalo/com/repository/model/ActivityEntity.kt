package alancasasarevalo.com.repository.model

import android.util.Log
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ActivityEntity (val id: Long,
                           val dataBaseId: Long,
                           val name: String,
                           val img: String,
                           @JsonProperty("logo_img") val logoImg: String,
                           val address: String,
                           val url: String,
                           val telephone: String,
                           val email: String,
                           @JsonProperty("special_offer") val specialOffer:String,
                           @JsonProperty("description_en") val description:String,
                           @JsonProperty("gps_lat") val latitude: String,
                           @JsonProperty("gps_lon") val longitude: String,
                           @JsonProperty("opening_hours_en")val openingHours: String = "",
                           @JsonProperty("keywords_en")val keywords: String = ""
){

    // TODO: Hacer lo de los datos gps.
    fun getCorrectCoordinateComponent(coordinateComponent: String): Float {
        var coordinate = 0.0f
        val s = coordinateComponent.replace(",", "")
        try {
            coordinate = java.lang.Float.parseFloat(s)
        } catch (e: Exception) {
            Log.d("ERROR CONVERTING", String.format("Can't convert %s", coordinateComponent))
        }
        return coordinate
    }
}