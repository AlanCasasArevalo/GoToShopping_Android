package alancasasarevalo.com.repository.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
internal class ActivitiesResponseEntity (val result: List<ActivityEntity>)