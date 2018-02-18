package alancasasarevalo.com.domain.models

interface ReadAggregate <T> {
    fun getCountElementList() : Int
    fun getAllElements() : List<T>
    fun getElementByPosition(position: Int) : T
}

interface WriteAggregate <T> {
    fun addNewElement(element: T)
    fun deleteElementByPosition(position: Int)
    fun delete(element: T)
}

interface AggregateInterface <T> : ReadAggregate<T>, WriteAggregate<T>