package alancasasarevalo.com.repository.util

import android.util.Log

fun Any?.toString(): String {
    if (this == null) return "null"
    // after the null check, 'this' is autocast to a non-null type, so the toString() below
    // resolves to the member function of the Any class
    return toString()
} fun getCorrectCoordinateComponent(coordinateComponent: String): Float {
    // problem: JSON has this errors "-3.9018104,275"
    var coordinate = 0.0f
    val s = coordinateComponent.replace(",", "")
    try {
        coordinate = java.lang.Float.parseFloat(s)
    } catch (e: Exception) {
        Log.d("ERROR CONVERTING", String.format("Can't convert %s", coordinateComponent))
    }
    return coordinate
}