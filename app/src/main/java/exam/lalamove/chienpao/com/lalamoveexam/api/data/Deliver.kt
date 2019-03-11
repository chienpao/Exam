package exam.lalamove.chienpao.com.lalamoveexam.api.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * The deliveries data model
 *
 * Data example:
 * [
        {
        "id": 0,
        "description": "Deliver documents to Andrio",
        "imageUrl": "https://s3-ap-southeast-1.amazonaws.com/xxxxxxxx-mock-api/images/pet-8.jpeg",
        "location": {
        "lat": 22.336093,
        "lng": 114.155288,
        "address": "Cheung Sha Wan"
        }
    ]
 */

@Parcelize
data class Deliver(
        @SerializedName("id") val id: Int,
        @SerializedName("description") val description: String,
        @SerializedName("imageUrl") val imageUrl: String,
        @SerializedName("location") val location: Location): Parcelable

@Parcelize
data class Location(
        @SerializedName("lat") val lat: Double,
        @SerializedName("lng") val lng: Double,
        @SerializedName("address") val address: String): Parcelable



