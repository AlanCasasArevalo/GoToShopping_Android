package alancasasarevalo.com.repository.network

import alancasasarevalo.com.repository.ErrorCompletion
import alancasasarevalo.com.repository.SuccessCompletion

interface GenericGetJsonManagerInterface {
    fun execute(urlT: String, urlZ: String, successCompletion: SuccessCompletion<String>, errorCompletion: ErrorCompletion)
}