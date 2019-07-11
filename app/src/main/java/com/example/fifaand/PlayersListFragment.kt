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
import com.example.fifaand.helper.Formatter
import com.example.fifaand.helper.runOnIoThread
import com.example.fifaand.tools.DBWorkerThread
import com.example.fifaand.tools.Mapper
import kotlinx.android.synthetic.main.fragment_players__list_.*
import kotlinx.android.synthetic.main.fragment_players__list_.view.*


class PlayersListFragment : Fragment(), RecyclerViewAdapter.ListOnClickListener {

    private val bundle = Bundle()
    private var  playerList= ArrayList<Player>()
    private lateinit var  dB : AppDatabase
    private val uiHandler = Handler()
    private lateinit var worker : DBWorkerThread

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_players__list_, container, false)
        val mapper = Mapper(Formatter())
        //val task = Runnable { dB!!.PlayerDao().getAllPlayers() }


        /*val linelist = arguments!!.getStringArrayList("playersList")!!
        if (linelist.isNullOrEmpty()) {
            Toast.makeText(context, "Load CSV file first", Toast.LENGTH_SHORT).show()
            return view
        }*/

        //playerList = ArrayList(linelist.map { mapper.map(it) })
        val playersRecyclerView = view.playersRecyclerView
        val playerAdapter = RecyclerViewAdapter(playerList, this)
        playersRecyclerView.adapter = playerAdapter
        playersRecyclerView.layoutManager = LinearLayoutManager(context)
        dB = (activity as MainActivity).mDb!!
        worker = (activity as MainActivity).dbWorker
        worker.postTask(  Runnable{playerList.addAll(ArrayList(dB!!.PlayerDao().getAllPlayers()))
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
    private fun fetchDataFromDB(){
        val task = Runnable {
            val players = dB!!.PlayerDao().getAllPlayers()
            uiHandler.post {
                if (players == null || players?.size == 0) {
                    Toast.makeText(context, "No data in cache..!!", Toast.LENGTH_SHORT).show()
                } else {
                    bindDBWithData(players = players?.get(0))
                }
            }

        }
        worker.postTask(task)
    }

    private fun bindDBWithData(players: Player) {
        playerList.add(players)

    }


}
