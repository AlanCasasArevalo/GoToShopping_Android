package alancasasarevalo.com.repository.dao

data class ActivityEntity (val id: Long,
                           val dataBaseId: Long,
                           val name: String,
//                       @JsonProperty("description_en") val description:String,
                           val img: String,
//                       @JsonProperty("logo_img") val logo: String,
                           val logo: String,
                           val address: String,
                           val url: String,
                           val telephone: String,
                           val email: String,
                           val specialOffer : String,

                           val description_en: String,
//                       @JsonProperty("gps_lat") val latitude: String,
                           val latitude: String,
//                       @JsonProperty("gps_lon") val longitude: String,
                           val longitude: String,
                           val opening_hours_en: String,
                           val keywordsEn: String
//                       @JsonProperty("openingHours")val openingHours: String = "",
)