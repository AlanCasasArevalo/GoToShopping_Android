package alancasasarevalo.com.domain.models

import alancasasarevalo.com.domain.AggregateInterface

class MadridActivities (val activies : MutableList<MadridActivity>) : AggregateInterface<MadridActivity> {
    override fun getCountElementList(): Int {
        return activies.size
    }

    override fun getAllElements(): List<MadridActivity> {
        return activies
    }

    override fun getElementByPosition(position: Int): MadridActivity {
        return activies[position]
    }

    override fun addNewElement(element: MadridActivity) {
        activies.add(element)
    }

    override fun deleteElementByPosition(position: Int) {
        activies.removeAt(position)
    }

    override fun delete(element: MadridActivity) {
        activies.remove(element)
    }
}