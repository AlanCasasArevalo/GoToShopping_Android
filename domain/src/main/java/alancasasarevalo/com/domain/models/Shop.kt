package alancasasarevalo.com.domain.models

import android.os.Parcel
import android.os.Parcelable


data class Shop(val id: Int,
                val name: String,
                val img: String,
                val logoImg: String,
                val address: String,
                val url: String,
                val telephone: String,
                val email: String,
                val specialOffer: Boolean,
                val descriptionEn: String,
                val gpsLati: String,
                val gpsLong: String,
                val openingHoursEn: String,
                val keywordsE: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(img)
        parcel.writeString(logoImg)
        parcel.writeString(address)
        parcel.writeString(url)
        parcel.writeString(telephone)
        parcel.writeString(email)
        parcel.writeByte(if (specialOffer) 1 else 0)
        parcel.writeString(descriptionEn)
        parcel.writeString(gpsLati)
        parcel.writeString(gpsLong)
        parcel.writeString(openingHoursEn)
        parcel.writeString(keywordsE)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Shop> {
        override fun createFromParcel(parcel: Parcel): Shop {
            return Shop(parcel)
        }

        override fun newArray(size: Int): Array<Shop?> {
            return arrayOfNulls(size)
        }
    }
}