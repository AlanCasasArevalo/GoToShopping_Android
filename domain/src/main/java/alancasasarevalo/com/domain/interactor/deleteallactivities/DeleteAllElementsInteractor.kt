package alancasasarevalo.com.domain.interactor.deleteallactivities

import alancasasarevalo.com.domain.interactor.CodeClousure
import alancasasarevalo.com.domain.interactor.ErrorClosure

interface DeleteAllElementsInteractor <out T> {
    fun execute(successClosure: CodeClousure, errorClosure: ErrorClosure)
}
