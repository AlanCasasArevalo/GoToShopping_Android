package alancasasarevalo.com.domain.models

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@SuppressLint("ParcelCreator")
@Parcelize
data class Shops (val shops: MutableList<Shop>) : AggregateInterface<Shop>, Parcelable {
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