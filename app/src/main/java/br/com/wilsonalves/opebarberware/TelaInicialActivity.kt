package br.com.wilsonalves.opebarberware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class TelaInicialActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val args = intent.extras
        val nome_usuario = args?.getString("nome_usuario")

        Toast.makeText(this, "Usuário: $nome_usuario", Toast.LENGTH_LONG).show()

//        msgTelaInicial.text = nome_usuario

        supportActionBar?.title = "Tela Inicial"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
        if(id == R.id.action_buscar){
            Toast.makeText(this, "Botão de buscar", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_atualizar) {
            Toast.makeText(this, "Botão atualizar", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_config) {
            Toast.makeText(this, "Botão de configurações", Toast.LENGTH_LONG).show()
        } else if (id == android.R.id.home) {
            //Voltar para a tela inicial usando destroy
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

}