package com.example.fifaand


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fifaand.Models.Player
import com.example.fifaand.entities.PlayerEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_single_card.view.*


class SingleCardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val player = arguments!!.getSerializable("Player")!! as PlayerEntity
        val view = inflater.inflate(R.layout.fragment_single_card, container, false)
        view.Name.text = player.name
        view.Position.text = player.position
        view.OverallRating.text = player.overall.toString()
        view.Weight.text = player.weight
        view.Height.text = player.height
        view.PrefFoot.text = player.preferredFoot
        view.JerseyNumber.text = player.jerseyNumber.toString()
        view.SkillMoves.text = player.skillMoves.toString()
        view.WeakerFoot.text = player.weakFoot.toString()
        Picasso.get().load(player.photo).resize(700,700).into(view.CardPhoto)
        Picasso.get().load(player.clubLogo).resize(160,160).into(view.ClubLogo)
        Picasso.get().load(player.flag).resize(200,140).into(view.Flag)
        return view
    }


}
