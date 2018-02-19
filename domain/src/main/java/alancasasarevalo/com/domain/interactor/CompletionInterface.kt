package alancasasarevalo.com.domain.interactor

interface SuccessCompletion <in T> {
    fun successCompletion (elements: T)
}

interface ErrorCompletion {
    fun errorCompletion (errorMessage: String)
}