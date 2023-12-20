package br.com.ericandrade.hearthstoneapi.repository.remote.service.response

import com.google.gson.annotations.SerializedName

class ClassicResponse(
    @SerializedName("cardId") val cardId : String,
    @SerializedName("dbfId") val dbfId : Int,
    @SerializedName("name") val name : String,
    @SerializedName("cardSet") val cardSet : String,
    @SerializedName("type") val type : String,
    @SerializedName("faction") val faction : String,
    @SerializedName("rarity") val rarity : String,
    @SerializedName("text") val textDescription : String,
    @SerializedName("race") val race : String,
    @SerializedName("playerClass") val playerClass : String,
    @SerializedName("locale") val locale : String,
    @SerializedName("img") val img : String,
    @SerializedName("imgGold") val imgGold : String,
    @SerializedName("attack") val attack : Int,
    @SerializedName("cost") val cost : Int,
    @SerializedName("flavor") val flavor : String,
    @SerializedName("health") val health : Int
)