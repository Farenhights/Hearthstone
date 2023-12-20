package br.com.ericandrade.hearthstoneapi.ui.cards.viewModel

import androidx.lifecycle.MutableLiveData
import br.com.ericandrade.hearthstoneapi.domain.general.Card
import br.com.ericandrade.hearthstoneapi.domain.general.Classic
import br.com.ericandrade.hearthstoneapi.repository.remote.HearthStoneRepository
import br.com.ericandrade.hearthstoneapi.ui.base.BaseViewModel
import br.com.ericandrade.hearthstoneapi.ui.cards.model.CardsModel

class CardsViewModel(
    private val hearthStoneRepository: HearthStoneRepository
): BaseViewModel() {

    internal val cardsLiveData = MutableLiveData<Card>()

    fun getCards() {
        loadingLiveData.value = true
        hearthStoneRepository.getCards(
            ::onGetCardsSuccess,
            ::onFailure
        )
    }

    private fun onGetCardsSuccess(card: Card) {
        loadingLiveData.value = false
        var newCard: Card? = null
        val newClassicCardList = arrayListOf<Classic>()

        filterCardsWithImage(card, newClassicCardList)

        newCard = Card(classic = newClassicCardList.toList())
        cardsLiveData.value = newCard
    }

    private fun filterCardsWithImage(
        card: Card,
        newClassicCardList: ArrayList<Classic>
    ) {
        card.classic.forEach {
            if (it.img.isNotEmpty()) {
                newClassicCardList.add(it)
            }
        }
    }

    private fun onFailure(throwable: Throwable) {
        loadingLiveData.value = false

    }
}