package com.example.fifaand


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fifaand.adapters.RecyclerViewAdapter
import com.example.fifaand.helper.Formatter
import com.example.fifaand.tools.Mapper
import kotlinx.android.synthetic.main.fragment_players__list_.view.*


class PlayersListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_players__list_, container, false)
        val mapper = Mapper(Formatter())
        val linelist =arguments!!.getStringArrayList("playersList")
        val playerslist = ArrayList(linelist!!.map { mapper.map(it) })
        val playersRecyclerView = view.playersRecyclerView
        playersRecyclerView.adapter = RecyclerViewAdapter(playerslist)
        playersRecyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }


}
