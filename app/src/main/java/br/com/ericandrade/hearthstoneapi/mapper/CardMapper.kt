package br.com.ericandrade.hearthstoneapi.mapper

import br.com.ericandrade.hearthstoneapi.domain.general.Basic
import br.com.ericandrade.hearthstoneapi.domain.general.Card
import br.com.ericandrade.hearthstoneapi.domain.general.Classic
import br.com.ericandrade.hearthstoneapi.repository.remote.service.response.CardResponse

class CardMapper {
    companion object {

        fun toDomain(cardResponse: CardResponse): Card {
            var card: Card? = null
//            val cardBasicList = arrayListOf<Basic>()
            val cardClassicList = arrayListOf<Classic>()

            cardResponse.classicResponse.forEach { classicResponse ->
                cardClassicList.add(
                    Classic(
                        cardId = classicResponse.cardId ?: String(),
                        dbfId = classicResponse.dbfId,
                        name = classicResponse.name ?: String(),
                        cardSet = classicResponse.cardSet ?: String(),
                        type = classicResponse.type ?: String(),
                        faction = classicResponse.faction ?: String(),
                        rarity = classicResponse.rarity ?: String(),
                        textDescription = classicResponse.textDescription ?: String(),
                        race = classicResponse.race ?: String(),
                        playerClass = classicResponse.playerClass ?: String(),
                        locale = classicResponse.locale ?: String(),
                        img = classicResponse.img ?: String(),
                        imgGold = classicResponse.imgGold ?: String(),
                        attack = classicResponse.attack,
                        cost = classicResponse.cost,
                        flavor = classicResponse.flavor ?: String(),
                        health = classicResponse.health
                    )
                )
            }

            card = Card(
                classic = cardClassicList
            )

            return card
        }
    }
}