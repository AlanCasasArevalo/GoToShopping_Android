package alancasasarevalo.com.repository

// TODO: hacer algo para que esto devuelva las tiendas y las actividades.
interface SuccessCompletion <in T> {
    fun successCompletion (elements: T)
}

interface ErrorCompletion {
    fun errorCompletion (errorMessage: String)
}