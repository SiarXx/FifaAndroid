package com.example.fifaand


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.HandlerThread
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.room.Database
import com.example.fifaand.helper.CSVFileReader
import com.example.fifaand.helper.Formatter
import com.example.fifaand.helper.runOnIoThread
import com.example.fifaand.tools.DBWorkerThread
import com.example.fifaand.tools.Mapper
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment(), View.OnClickListener {
    private lateinit var dialog: AlertDialog
    private val fileRequestCode = 2137
    private var bundle = Bundle()

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
            R.id.playerListBtn -> Navigation.findNavController(view).navigate(R.id.action_listFragment_to_players_List_Fragment,bundle)
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
        //val path = Environment.getExternalStorageDirectory().path + data!!.data!!.path!!.replace("external_files/", "")
        var list: ArrayList<String>
        val mapper= Mapper(Formatter())

        when (requestCode) {
            fileRequestCode -> {
                // Log.d("path: ", path)
                data.let { intent ->
                    list = csv.readFileByLine(context!!.contentResolver, intent!!.data!!)
                }
                val playerlist = list.map { mapper.map(it) }
                val dB = (activity as MainActivity).mDb
                val worker = (activity as MainActivity).dbWorker
             //   worker.postTask(Runnable {dB!!.PlayerDao().deleteAllPlayers()})
                val task = Runnable {  dB!!.PlayerDao().insertPlayer(*playerlist.toTypedArray()) }
                worker.postTask(task)
                Log.d("First: ", list[0])
                bundle.putStringArrayList("playersList", list)
            }
            else -> Toast.makeText(context, "Stahp", Toast.LENGTH_SHORT).show()
        }
    }
}
