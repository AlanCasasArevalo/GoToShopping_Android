package alancasasarevalo.com.domain.models

import alancasasarevalo.com.domain.AggregateInterface

class Shops (val shops: MutableList<Shop>) : AggregateInterface<Shop> {
    override fun getCountElementList(): Int {
        return shops.size
    }

    override fun getAllElements(): List<Shop> {
        return shops
    }

    override fun getElementByPosition(position: Int): Shop {
        return shops[position]
    }

    override fun addNewElement(element: Shop) {
        shops.add(element)
    }

    override fun deleteElementByPosition(position: Int) {
        shops.removeAt(position)
    }

    override fun delete(element: Shop) {
        shops.remove(element)
    }
}