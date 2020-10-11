package br.com.wilsonalves.opebarberware

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_portifolio_activitiy.*
import kotlinx.android.synthetic.main.navigation_view.*
import kotlinx.android.synthetic.main.toolbar.*

class PortifolioActivitiy : DebugActivity() {
    private var portifolio = listOf<Portifolio>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portifolio_activitiy)
        this.genericLayoutMenu = layoutMenuLateral
        this.genericMenuLateral = menu_lateral

        setSupportActionBar(toolbar_view)
        supportActionBar?.title = "Portifolio"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        recyclerPortifolio?.layoutManager = LinearLayoutManager(this)
        recyclerPortifolio?.itemAnimator = DefaultItemAnimator()
        recyclerPortifolio?.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskPortifolio()
    }

    fun taskPortifolio() {
        this.portifolio = PortifolioService.getPortifolio()

        recyclerPortifolio?.adapter = PortifolioAdapter(this.portifolio) {onClickPortifolio(it)}
    }

    fun onClickPortifolio(portifolio: Portifolio) {
        var it = Intent(this, PortifolioDetailsActivity::class.java)
        it.putExtra("descricao", portifolio)
        startActivity(it)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // id do item clicado
        val id = item?.itemId
        // verificar qual item foi clicado e mostrar a mensagem
        //Toast na tela
        //a comparação é feita com o recurso de id definido no "menu_main"xml
        if(id == R.id.searchView){
            Toast.makeText(this, "Botão de buscar", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_atualizar) {
            Toast.makeText(this, "atualizazado", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_config) {
            Toast.makeText(this, "Botão de configurações", Toast.LENGTH_LONG).show()
        } else if (id == android.R.id.home) {
            //Voltar para a tela inicial usando destroy
            val intent = Intent(this, TelaInicialActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}