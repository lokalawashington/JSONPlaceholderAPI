package com.kanyideveloper.jsonplaceholderapi


import com.google.gson.annotations.SerializedName

class JsonPlaceholder : ArrayList<JsonPlaceholder.JsonPlaceholderItem>(){
    data class JsonPlaceholderItem(
        @SerializedName("albumId")
        val albumId: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("thumbnailUrl")
        val thumbnailUrl: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("url")
        val url: String
    )
}