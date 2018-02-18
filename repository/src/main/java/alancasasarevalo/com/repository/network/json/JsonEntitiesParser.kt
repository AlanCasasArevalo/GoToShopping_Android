package alancasasarevalo.com.repository.network.json

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class JsonEntitiesParser {
    val mapper = jacksonObjectMapper()

    // TODO:Hacer que el parseo elimine las comas de los latitude y longitude

    inline fun <reified T: Any>parse(json: String): T {
        return this.mapper.readValue<T>(json)
    }

}