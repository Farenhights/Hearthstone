package br.com.ericandrade.hearthstoneapi.ui.cards.view

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import br.com.ericandrade.hearthstoneapi.R
import androidx.lifecycle.Observer
import br.com.ericandrade.hearthstoneapi.databinding.ActivityCardsBinding
import br.com.ericandrade.hearthstoneapi.domain.general.Classic
import br.com.ericandrade.hearthstoneapi.ui.base.BaseActivity
import br.com.ericandrade.hearthstoneapi.ui.cardDetail.view.CardDetailActivity
import br.com.ericandrade.hearthstoneapi.ui.cards.viewModel.CardsViewModel
import org.koin.android.ext.android.inject

class CardsActivity : BaseActivity() {

    private val viewModel: CardsViewModel by inject()

    private val binding: ActivityCardsBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_cards
        ) as ActivityCardsBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        setBinding()
        setObservables()
        setView()
    }

    private fun setBinding() {
        binding.viewModel = viewModel
    }

    private fun setObservables() {
        binding.viewModel!!.loadingLiveData.observe(this@CardsActivity, Observer { shouldShow ->
            showIndeterminateProgressDialog(R.string.wait, shouldShow)
        })

        binding.viewModel!!.cardsLiveData.observe(
            this,
            Observer { card ->
                binding.cardsRecyclerView.adapter = CardsAdapter(card, ::onClickCard)
            }
        )
    }

    private fun onClickCard(card: Classic) {
        val bundle = Bundle()
        val intent = Intent(this, CardDetailActivity::class.java)
        intent.putExtra(CardDetailActivity.CARD_DETAIL, card)

        startActivity(intent, bundle)
    }

    private fun setView() {
        loadCards()
    }

    private fun loadCards() {
        binding.viewModel!!.getCards()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}