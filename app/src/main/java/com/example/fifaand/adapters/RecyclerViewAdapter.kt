package com.example.fifaand.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fifaand.Models.Player
import com.example.fifaand.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_player_list.view.*

class RecyclerViewAdapter(
    private val players: ArrayList<Player>,
    private val listOnClickListener: ListOnClickListener
) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    interface ListOnClickListener {
        fun onClickNav(position: Int)
    }

    inner class MyViewHolder(container: View) : RecyclerView.ViewHolder(container) {

        val playerID: TextView = container.IDNumber
        val playerName: TextView = container.Name
        val playerAge: TextView = container.Age
        val playerNationality: TextView = container.Nationality
        val playerPhoto: ImageView = container.photo

        init {
            container.setOnClickListener {
                listOnClickListener.onClickNav(adapterPosition)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.single_player_list, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val player = players[position]
        holder.playerID.text = player.id.toString()
        holder.playerAge.text = player.age.toString()
        holder.playerName.text = player.name
        holder.playerNationality.text = player.nationality
        Picasso.get().load(player.photo).resize(100, 100).into(holder.playerPhoto)


    }

    override fun getItemCount() = players.size


}