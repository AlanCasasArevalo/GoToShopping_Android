package alancasasarevalo.com.repository.cache

interface CacheInterface <T>{
    fun getAllElements(successCompletion: (elements: List<T>) -> Unit, errorCompletion: (errorMessage: String) -> Unit)
    fun saveAllElements( elements: List<T>, successCompletion: () -> Unit, errorCompletion: (errorMessage: String) -> Unit )
    fun deleteAllElements(successCompletion: () -> Unit, errorCompletion: (errorMessage: String) -> Unit)
}