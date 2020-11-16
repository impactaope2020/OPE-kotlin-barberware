package br.com.wilsonalves.opebarberware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_novo_portifolio.*


class NovoPortifolioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_portifolio)

        salvarPortifolio.setOnClickListener{
            Thread{
                val portifolio = Portifolio()
                portifolio.descricao = descricao.text.toString()
                portifolio.imagem = imagem.text.toString()

                PortifolioService.save(portifolio)
                runOnUiThread {
                    finish()
                }
            }.start()
        }
    }
}