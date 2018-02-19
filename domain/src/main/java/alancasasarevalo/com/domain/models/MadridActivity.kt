package alancasasarevalo.com.domain.models

data class MadridActivity(val id: Int,
                          val name: String,
                          val img: String,
                          val logoImg: String,
                          val address: String,
                          val url: String,
                          val telephone: String,
                          val email: String,
                          val specialOffer: Boolean,
                          val descriptionEn: String,
                          val gpsLati: String,
                          val gpsLong: String,
                          val openingHoursEn: String,
                          val keywordsE: String
)