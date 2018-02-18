package alancasasarevalo.com.domain.domain_network

import alancasasarevalo.com.domain.interactor.CodeClousure
import alancasasarevalo.com.domain.interactor.ErrorClosure

interface InternetStatusInteractorInterface {
    fun execute(success: CodeClousure, error: ErrorClosure)
}