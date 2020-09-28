package br.com.wilsonalves.opebarberware

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class CadastrarAgendamentoActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_agendamento)

        progress.visibility = View.VISIBLE

        supportActionBar?.title = "Agendamento"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        progress.visibility = View.GONE
    }
    //    função sobrescrita para inflar o menu na ActionBar

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