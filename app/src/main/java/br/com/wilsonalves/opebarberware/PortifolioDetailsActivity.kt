package br.com.wilsonalves.opebarberware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class PortifolioDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portifolio_details)

        var portifolio = intent.getSerializableExtra("descricao")

        Toast.makeText(this, "$portifolio", Toast.LENGTH_LONG).show()
    }
}