package alancasasarevalo.com.domain.interactor.deleteallactivities

import alancasasarevalo.com.domain.interactor.CodeClousure
import alancasasarevalo.com.domain.interactor.ErrorClosure
import alancasasarevalo.com.domain.models.MadridActivities
import alancasasarevalo.com.repository.ActivityRepositoryImplementation
import android.content.Context
import java.lang.ref.WeakReference

class DeleteAllActivitiesImplementation (context: Context) : DeleteAllElementsInteractor<MadridActivities>{
    var weakContext = WeakReference<Context>(context)

    override fun execute(successClosure: CodeClousure, errorClosure: ErrorClosure) {
        val repository = ActivityRepositoryImplementation(weakContext.get()!!)

        repository.deleteAllElements(successClosure, errorClosure)
    }
}

