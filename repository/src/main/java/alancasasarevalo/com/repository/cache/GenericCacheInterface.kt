package alancasasarevalo.com.repository.cache

interface GenericCacheInterface<T, Z> {
    fun getAllElements(successCompletionElement: (elements: List<T>, List<Z>) -> Unit, errorCompletion: (errorMessage: String) -> Unit)
    fun saveAllElements(elementsT: List<T>,elementsZ: List<Z>, successCompletion: () -> Unit, errorCompletion: (errorMessage: String) -> Unit)
    fun deleteAllElements(successCompletionElementT: () -> Unit,successCompletionElementZ: () -> Unit, errorCompletion: (errorMessage: String) -> Unit)
}