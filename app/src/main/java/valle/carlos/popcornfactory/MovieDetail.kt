package valle.carlos.popcornfactory

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import org.w3c.dom.Text

class MovieDetail : AppCompatActivity() {

    var peliculas = ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val bundle = intent.extras
        var ns = 0
        var id = -1
        var title = ""

        var header_image: ImageView = findViewById(R.id.header_image)
        var sinopsis: TextView = findViewById(R.id.sinopsis)
        var titulo: TextView = findViewById(R.id.titulo)
        var asientos: TextView= findViewById(R.id.sits)
        var buyTickets: Button = findViewById(R.id.buyTickets)

        if (bundle != null) {

            ns = bundle.getInt("sits")

            title = bundle.getString("titulo")!!
            header_image.setImageResource(bundle.getInt("header"))
            sinopsis.setText(bundle.getString("sinopsis"))
            titulo.setText(bundle.getString("titulo"))
            asientos.setText("$ns seats available")
            id= bundle.getInt("pos")
        }

        if(ns==0){
            buyTickets.isEnabled= false
        }else{
            buyTickets.isEnabled=true
            buyTickets.setOnClickListener{
                val intent: Intent= Intent(this, SeatSelection::class.java)

                intent.putExtra("movie", id)
                intent.putExtra("name", title)

                this.startActivity(intent)
            }
        }
    }
}