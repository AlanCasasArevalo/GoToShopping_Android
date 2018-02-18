package alancasasarevalo.com.domain.interactor

typealias SuccessClosure <Element>  = ( element: Element) -> Unit
typealias ErrorClosure = (msg: String) -> Unit
typealias CodeClousure = () -> Unit