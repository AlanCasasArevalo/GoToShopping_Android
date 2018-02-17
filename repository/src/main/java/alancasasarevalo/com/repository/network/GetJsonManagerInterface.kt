package alancasasarevalo.com.repository.network

import alancasasarevalo.com.repository.ErrorCompletion
import alancasasarevalo.com.repository.SuccessCompletion

interface GetJsonManagerInterface {
    fun execute(url: String, successCompletion: SuccessCompletion<String>, errorCompletion: ErrorCompletion)
}