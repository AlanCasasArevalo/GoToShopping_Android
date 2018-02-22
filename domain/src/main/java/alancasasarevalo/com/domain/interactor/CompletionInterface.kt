package alancasasarevalo.com.domain.interactor

interface SuccessCompletion <in T, in Z> {
    fun successCompletion (elementsT: T, elementsZ: Z)
}

interface ErrorCompletion {
    fun errorCompletion (errorMessage: String)
}