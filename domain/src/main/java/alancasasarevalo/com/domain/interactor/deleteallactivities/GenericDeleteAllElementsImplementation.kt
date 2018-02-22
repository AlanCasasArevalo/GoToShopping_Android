package alancasasarevalo.com.domain.interactor.deleteallactivities

import alancasasarevalo.com.domain.interactor.CodeClousure
import alancasasarevalo.com.domain.interactor.ErrorClosure
import alancasasarevalo.com.repository.GenericRepositoryImplementation
import android.content.Context
import java.lang.ref.WeakReference

class GenericDeleteAllElementsImplementation(context: Context) : DeleteAllElementsInteractor {
    var weakContext = WeakReference<Context>(context)

    override fun execute(successClosureShops: CodeClousure, successClosureActivities: CodeClousure, errorClosure: ErrorClosure) {
        val repository = GenericRepositoryImplementation(weakContext.get()!!)
        repository.deleteAllElements(successClosureShops, successClosureActivities, errorClosure)
    }

}