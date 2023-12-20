package br.com.ericandrade.hearthstoneapi.ui.cards.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.ericandrade.hearthstoneapi.R
import br.com.ericandrade.hearthstoneapi.domain.general.Card
import br.com.ericandrade.hearthstoneapi.domain.general.Classic
import com.squareup.picasso.Picasso

class CardsAdapter(
    private val card: Card,
    private val onClick: (Classic) -> Unit
) : RecyclerView.Adapter<CardsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val classicCard = card.classic[position]

        Picasso.get()
            .load(classicCard.img)
            .into(holder.cardImage)

        holder.cardImage.setOnClickListener { onClick(classicCard) }
    }

    override fun getItemCount(): Int {
        return card.classic.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardImage: ImageView = view.findViewById(R.id.cardImageView)
    }
}