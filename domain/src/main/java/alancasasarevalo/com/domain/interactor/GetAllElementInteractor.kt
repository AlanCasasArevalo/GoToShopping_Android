package alancasasarevalo.com.domain.interactor

import alancasasarevalo.com.domain.ErrorCompletion
import alancasasarevalo.com.domain.SuccessCompletion
import alancasasarevalo.com.domain.models.MadridActivities
import alancasasarevalo.com.domain.models.Shops

interface GetAllElementInteractor {
    fun execute(successShops: SuccessCompletion<Shops>, successActivities: SuccessCompletion<MadridActivities>, error: ErrorCompletion)
}