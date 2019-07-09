package com.example.fifaand


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fifaand.adapters.RecyclerViewAdapter
import com.example.fifaand.helper.Formatter
import com.example.fifaand.tools.Mapper
import kotlinx.android.synthetic.main.fragment_players__list_.view.*


class PlayersListFragment : Fragment(), RecyclerViewAdapter.ListOnClickListener {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_players__list_, container, false)
        val mapper = Mapper(Formatter())
        val linelist = arguments!!.getStringArrayList("playersList")
        if (linelist == null) {
            Toast.makeText(context, "Load CSV file first", Toast.LENGTH_SHORT).show()
            return view
        }

        val playerslist = ArrayList(linelist!!.map { mapper.map(it) })
        val playersRecyclerView = view.playersRecyclerView
        playersRecyclerView.adapter = RecyclerViewAdapter(playerslist, this)
        playersRecyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }
    override fun onClickNav(position: Int) {
        Log.d("Position", position.toString())
        Navigation.findNavController(view!!).navigate(R.id.action_players_List_Fragment_to_singleCardFragment)
    }


}
