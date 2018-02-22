package alancasasarevalo.com.domain.interactor.getallinteractor

interface GenericRepositoryInterface  <out El, T> {
        fun getAllElements(successCompletionGenericElementEl: (element: List<El>) -> Unit,successCompletionElementT: (element: List<T>) -> Unit, errorCompletion: (errorMessage: String) -> Unit)
        fun deleteAllElements(successCompletion: () -> Unit, errorCompletion: (errorMessage: String) -> Unit)
}