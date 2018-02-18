package alancasasarevalo.com.repository

interface RepositoryInterface <out T> {
    fun getAllElements(successCompletion: (element: List<T>) -> Unit, errorCompletion: (errorMessage: String) -> Unit)
    fun deleteAllElements(successCompletion: () -> Unit, errorCompletion: (errorMessage: String) -> Unit)
}