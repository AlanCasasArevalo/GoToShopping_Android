package alancasasarevalo.com.domain.interactor.getallinteractor

import alancasasarevalo.com.domain.interactor.ErrorCompletion
import alancasasarevalo.com.domain.interactor.SuccessCompletion
import alancasasarevalo.com.domain.models.MadridActivities
import alancasasarevalo.com.domain.models.Shops

interface GetAllElementInteractor {
    fun execute(successShops: SuccessCompletion<Shops?, MadridActivities?>, error: ErrorCompletion)
}