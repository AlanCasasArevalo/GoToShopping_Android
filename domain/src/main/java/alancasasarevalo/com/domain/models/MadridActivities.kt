package alancasasarevalo.com.domain.models

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class MadridActivities (val activities: MutableList<MadridActivity>) : AggregateInterface<MadridActivity> , Parcelable{
    override fun getCountElementList(): Int {
        return activities.size
    }

    override fun getAllElements(): List<MadridActivity> {
        return activities
    }

    override fun getElementByPosition(position: Int): MadridActivity {
        return activities[position]
    }

    override fun addNewElement(element: MadridActivity) {
        activities.add(element)
    }

    override fun deleteElementByPosition(position: Int) {
        activities.removeAt(position)
    }

    override fun delete(element: MadridActivity) {
        activities.remove(element)
    }
}