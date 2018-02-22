package alancasasarevalo.com.repository

interface GenericRepositoryInterface  <out T,out Z> {
        fun getAllElements(successCompletionElementT: (element: List<T>, List<Z>) -> Unit, errorCompletion: (errorMessage: String) -> Unit)
        fun deleteAllElements(successCompletionElementT: () -> Unit,successCompletionElementZ: () -> Unit, errorCompletion: (errorMessage: String) -> Unit)
}