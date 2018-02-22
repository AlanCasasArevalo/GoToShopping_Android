package alancasasarevalo.com.domain.interactor.deleteallactivities

import alancasasarevalo.com.domain.interactor.CodeClousure
import alancasasarevalo.com.domain.interactor.ErrorClosure

interface DeleteAllElementsInteractor {
    fun execute(successClosureShops: CodeClousure, successClosureActivities: CodeClousure, errorClosure: ErrorClosure)
}
