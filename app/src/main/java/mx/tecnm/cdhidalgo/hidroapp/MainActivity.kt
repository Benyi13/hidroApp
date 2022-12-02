package mx.tecnm.cdhidalgo.hidroapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var cambio:Int;
        cambio = 100;
        change(cambio);

        var refrescar = findViewById<Button>(R.id.btnRefresh);
             refrescar.setOnClickListener {
                 Toast.makeText(this, "No hay Agua", Toast.LENGTH_SHORT).show()
             cambio=cambio-25;
                 if(cambio<=0){
                     cambio=100;
                     change(cambio)
                 }
                 else{
                     change(cambio)
                 }
              }

    }


    fun change(n:Int){
        var n=n;

        var label = findViewById<TextView>(R.id.lblPorcentaje)
        label.setText(n.toString());

        if(n>=75){
            label.setTextColor(Color.parseColor("#68B984"))
        }
        else if(n>=50){
            label.setTextColor(Color.parseColor("#F49D1A"))
        }
        else if(n==25){
            label.setTextColor(Color.parseColor("#FF0000"))
        }

    }
}