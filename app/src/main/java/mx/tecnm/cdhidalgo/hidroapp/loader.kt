package mx.tecnm.cdhidalgo.hidroapp

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Pair
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class loader : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loader)

        var animacion: Animation;
        var animacion2: Animation;

        animacion = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);


        var  hydroblasTextView: TextView;
        var logoImageView: ImageView;

        hydroblasTextView=findViewById(R.id.hydroblasTextView)
        logoImageView=findViewById(R.id.logoImageView)


        hydroblasTextView.setAnimation(animacion2);
        logoImageView.setAnimation(animacion);


        val handler = Handler()
        handler.postDelayed({


            val intent = Intent(this, login::class.java)

            val pairs = listOf<Pair<View, String>>(
                Pair<View, String>(logoImageView, "logoImageTransition"),
                Pair<View, String>(hydroblasTextView, "bienvenidoTextTransition"),

            )




            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                val options: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this, pairs[0], pairs[1])
                Intent(this, login::class.java).also {
                    startActivity(it, options.toBundle())
                }
            }
            else{
                    startActivity(intent);

            }

            //Iniciar Activity despues de 4 segundos
            //startActivity(Intent(this,login::class.java))
        }, 4000)


    }
}