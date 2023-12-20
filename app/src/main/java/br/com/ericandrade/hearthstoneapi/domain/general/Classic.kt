package br.com.ericandrade.hearthstoneapi.domain.general

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class Classic(
    val cardId: String,
    val dbfId: Int,
    val name: String,
    val cardSet: String,
    val type: String,
    val faction: String,
    val rarity: String,
    val textDescription: String,
    val race: String,
    val playerClass: String,
    val locale: String,
    val img: String,
    val imgGold: String,
    val attack: Int,
    val health: Int,
    val cost: Int,
    val flavor: String
): Parcelable