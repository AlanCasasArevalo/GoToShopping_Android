package alancasasarevalo.com.domain.domain_network

import alancasasarevalo.com.domain.CodeClousure
import alancasasarevalo.com.domain.ErrorClosure

interface InternetStatusInteractorInterface {
    fun execute(success: CodeClousure, error: ErrorClosure)
}