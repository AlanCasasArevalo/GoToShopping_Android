package alancasasarevalo.com.repository.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ActivityEntity (val id: Long,
                           val dataBaseId: Long,
                           val name: String,
                           val img: String,
                           @JsonProperty("logo_img") val logo: String,
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
)