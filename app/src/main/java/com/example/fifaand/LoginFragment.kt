package com.example.fifaand


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.fifaand.Models.User
import com.example.fifaand.tools.DBWorkerThread
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import java.nio.file.attribute.UserPrincipalLookupService


class LoginFragment : Fragment(), View.OnClickListener {
    private lateinit var login: String
    private lateinit var password: String
    private lateinit var users: ArrayList<User>
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        users = (activity as MainActivity).users
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)



        view.loginBtn.setOnClickListener(this)
        view.registerBtn.setOnClickListener(this)
        return view
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.loginBtn -> checkUser()
            R.id.registerBtn -> Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun checkUser() {
        login = loginValue.text.toString()
        password = passValue.text.toString()
        if(users.any { it.login == login && it.password == password })
            Navigation.findNavController(loginValue).navigate(R.id.action_loginFragment_to_listFragment)
        else
            Toast.makeText(context, "Login or Password incorrect", Toast.LENGTH_SHORT).show()
    }
}
