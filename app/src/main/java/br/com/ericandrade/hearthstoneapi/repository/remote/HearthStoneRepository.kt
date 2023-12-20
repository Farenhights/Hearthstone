package br.com.ericandrade.hearthstoneapi.repository.remote

import br.com.ericandrade.hearthstoneapi.domain.general.Card
import br.com.ericandrade.hearthstoneapi.domain.general.CardType
import br.com.ericandrade.hearthstoneapi.mapper.CardMapper
import br.com.ericandrade.hearthstoneapi.mapper.CardTypeMapper
import br.com.ericandrade.hearthstoneapi.repository.remote.service.HeartStoneService
import io.reactivex.disposables.Disposable

class HearthStoneRepository(
    private val heartStoneService: HeartStoneService
) {
    fun getCards(
        onSuccess: (Card) -> Unit,
        onFailure: (Throwable) -> Unit
    ): Disposable {
        return heartStoneService
            .getCards()
            .map { cardsResponse -> CardMapper.toDomain(cardsResponse) }
            .subscribe(onSuccess, onFailure)
    }
}