package br.com.ericandrade.hearthstoneapi.ui.cardDetail.view

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import br.com.ericandrade.hearthstoneapi.R
import br.com.ericandrade.hearthstoneapi.databinding.ActivityCardDetailBinding
import br.com.ericandrade.hearthstoneapi.domain.general.Classic
import br.com.ericandrade.hearthstoneapi.ui.base.BaseActivity
import com.squareup.picasso.Picasso

class CardDetailActivity : BaseActivity() {

    companion object {
        const val CARD_DETAIL = "cardDetail"
    }

    private var card: Classic? = null

    private val binding: ActivityCardDetailBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_card_detail
        ) as ActivityCardDetailBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        loadValues()
        setView()
    }

    private fun loadValues() {
        card = intent.getParcelableExtra<Classic>(CARD_DETAIL) as? Classic
    }

    private fun buildToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun setView() {
        buildToolbar()
        loadValuesToComponents()
        setVisibility()
    }

    private fun loadValuesToComponents() {
        Picasso.get()
            .load(card?.img)
            .into(binding.cardImageView)
        binding.titleToolbarTextView.text = card?.name
        binding.attackTextView.text = card?.attack.toString()
        binding.costTextView.text = card?.cost.toString()
        binding.healthTextView.text = card?.health.toString()
    }

    private fun setVisibility() {
        if (card?.flavor?.isNotEmpty()!!) {
            binding.descriptionTextView.text = card?.flavor
            binding.descriptionTextView.visibility = View.VISIBLE
            binding.descriptionTitleTextView.visibility = View.VISIBLE
        }

        if (card?.textDescription?.isNotEmpty()!!) {
            binding.subDescriptionTextView.text = card?.textDescription
            binding.subDescriptionTextView.visibility = View.VISIBLE
            binding.subDescriptionTitleTextView.visibility = View.VISIBLE
        }

        if (card?.cardSet?.isNotEmpty()!!) {
            binding.setTextView.text = card?.cardSet
            binding.setTextView.visibility = View.VISIBLE
            binding.setTitleTextView.visibility = View.VISIBLE
        }

        if (card?.type?.isNotEmpty()!!) {
            binding.typeTextView.text = card?.type
            binding.typeTextView.visibility = View.VISIBLE
            binding.typeTitleTextView.visibility = View.VISIBLE
        }

        if (card?.faction?.isNotEmpty()!!) {
            binding.factionTextView.text = card?.faction
            binding.factionTextView.visibility = View.VISIBLE
            binding.factionTitleTextView.visibility = View.VISIBLE
        }

        if (card?.rarity?.isNotEmpty()!!) {
            binding.rarityTextView.text = card?.rarity
            binding.rarityTextView.visibility = View.VISIBLE
            binding.rarityTitleTextView.visibility = View.VISIBLE
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}