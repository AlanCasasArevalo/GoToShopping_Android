package alancasasarevalo.com.domain.domain_network

import alancasasarevalo.com.domain.interactor.CodeClousure
import alancasasarevalo.com.domain.interactor.ErrorClosure
import android.content.Context
import java.lang.ref.WeakReference

class InterenetStatusInteractorImplementation (context: Context) : InternetStatusInteractorInterface{

    private var weakContext = WeakReference<Context>(context)

    override fun execute(success: CodeClousure, error: ErrorClosure) {
        // TODO: make internet check implementation
    }
}
































