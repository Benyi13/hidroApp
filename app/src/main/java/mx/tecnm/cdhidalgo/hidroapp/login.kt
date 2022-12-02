package mx.tecnm.cdhidalgo.hidroapp

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.google.android.material.textfield.TextInputLayout
import mx.tecnm.cdhidalgo.iotapp.Config
import mx.tecnm.cdhidalgo.iotapp.MySingleton
import org.json.JSONObject

class login : AppCompatActivity() {

//    //variables de sesion son variables globales
    var sesion: SharedPreferences? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var email = findViewById<TextInputLayout>(R.id.txtUser)
        var pass = findViewById<TextInputLayout>(R.id.txtPass)
        sesion = getSharedPreferences("sesion", 0);
        var button = findViewById<Button>(R.id.btnIniciar)
        button.setOnClickListener {
          login()
        }
    }

    fun login() {
        startActivity(Intent(this,MainActivity::class.java))
    }



}