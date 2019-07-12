package com.example.fifaand


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.fifaand.entities.PlayerEntity
import com.example.fifaand.helper.CSVFileReader
import com.example.fifaand.helper.Formatter
import com.example.fifaand.tools.Mapper
import com.example.fifaand.tools.PlayerToEntityMapper
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment(), View.OnClickListener {
    private lateinit var dialog: AlertDialog
    private val fileRequestCode = 2137

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        dialog = AlertDialog.Builder(context!!)
            .setTitle("Close App")
            .setMessage("Are you sure you want to quit the app?")
            .setPositiveButton("YES") { p0, p1 -> activity?.finish() }
            .setNegativeButton("Cancel") { p0, p1 -> }
            .create()
        view.playerListBtn.setOnClickListener(this)
        view.loadPlayersBtn.setOnClickListener(this)
        view.exitBtn.setOnClickListener(this)

        return view
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.playerListBtn -> Navigation.findNavController(view).navigate(
                R.id.action_listFragment_to_players_List_Fragment)
            R.id.loadPlayersBtn -> pickFile()
            R.id.exitBtn -> dialog.show()
        }
    }

    private fun pickFile() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "file/*"
        startActivityForResult(intent, fileRequestCode)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val csv = CSVFileReader()
        var list: ArrayList<String>
        when (requestCode) {
            fileRequestCode -> {
                data.let { intent ->
                    list = csv.readFileByLine(context!!.contentResolver, intent!!.data!!)
                }
                val entitylist = reMapPlayers(list)
                val dB = (activity as MainActivity).mDb
                val worker = (activity as MainActivity).dbWorker
                val task = Runnable { dB!!.PlayerDao().insertPlayer(*entitylist.toTypedArray()) }
                worker.postTask(task)
            }
            else -> Toast.makeText(context, "Stahp", Toast.LENGTH_SHORT).show()
        }
    }

    private fun reMapPlayers(playersList: List<String>): List<PlayerEntity> {
        val mapper = Mapper(Formatter())
        val mapperE = PlayerToEntityMapper()
        val players = playersList.map { mapper.map(it) }
        return players.map { mapperE.mapE(it) }
    }
}
