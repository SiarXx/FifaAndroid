package com.example.fifaand


import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fifaand.Models.Player
import com.example.fifaand.adapters.RecyclerViewAdapter
import com.example.fifaand.entities.PlayerEntity
import com.example.fifaand.helper.Formatter
import com.example.fifaand.helper.runOnIoThread
import com.example.fifaand.tools.DBWorkerThread
import com.example.fifaand.tools.Mapper
import kotlinx.android.synthetic.main.fragment_players__list_.*
import kotlinx.android.synthetic.main.fragment_players__list_.view.*


class PlayersListFragment : Fragment(), RecyclerViewAdapter.ListOnClickListener {

    private val bundle = Bundle()
    private var  playerList= ArrayList<PlayerEntity>()
    private lateinit var  dB : AppDatabase
    private val uiHandler = Handler()
    private lateinit var worker : DBWorkerThread

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_players__list_, container, false)
        val playersRecyclerView = view.playersRecyclerView
        val playerAdapter = RecyclerViewAdapter(playerList, this)
        playersRecyclerView.adapter = playerAdapter
        playersRecyclerView.layoutManager = LinearLayoutManager(context)
        dB = (activity as MainActivity).mDb!!
        worker = (activity as MainActivity).dbWorker
        worker.postTask(  Runnable{playerList.addAll(ArrayList(dB.PlayerDao().getAllPlayers()))
            activity!!.runOnUiThread {
                playerAdapter.notifyDataSetChanged()
            }
        }
        )
        return view
    }
    override fun onClickNav(position: Int) {
        Log.d("Position", position.toString())
        bundle.putSerializable("Player", playerList[position])
        Navigation.findNavController(view!!).navigate(R.id.action_players_List_Fragment_to_singleCardFragment,bundle)
    }


}
