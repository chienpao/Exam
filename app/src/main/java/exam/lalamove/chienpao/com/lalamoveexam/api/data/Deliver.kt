package exam.lalamove.chienpao.com.lalamoveexam.api.data

import com.google.gson.annotations.SerializedName

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

data class Deliver(
        @SerializedName("id") val id: Int,
        @SerializedName("description") val description: String,
        @SerializedName("imageUrl") val imageUrl: String,
        @SerializedName("location") val location: Location)

data class Location(
        @SerializedName("lat") val lat: Float,
        @SerializedName("lng") val lng: Float,
        @SerializedName("address") val address: String
        )


