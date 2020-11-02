package br.com.wilsonalves.opebarberware

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import br.com.wilsonalves.lmsapp.Prefs
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.navigation_view.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        this.genericLayoutMenu = layoutMenuLateral
        this.genericMenuLateral = menu_lateral

        progress.visibility = View.VISIBLE

        val args = intent.extras
        val nome_usuario = args?.getString("nome_usuario")

        Toast.makeText(this, "Usuário: $nome_usuario", Toast.LENGTH_LONG).show()

        mensagemInicial.visibility = View.GONE

        setSupportActionBar(toolbar_view)
        supportActionBar?.title = "Tela Inicial"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()
//        Toast.makeText(this, Prefs.getString("curso"), Toast.LENGTH_LONG).show()

        progress.postDelayed(Runnable {
            progress.visibility = View.GONE
            mensagemInicial.visibility = View.VISIBLE
        }, 10000)

//        botaoSair.setOnClickListener{
//            finish()
//        }
//        botaoCadstrar.setOnClickListener{
//            val intent = Intent(this, CadastrarAgendamentoActivity::class.java)
//            startActivity(intent)
//        }

    }


//    função sobrescrita para inflar o menu na ActionBar

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchItem = menu?.findItem(R.id.searchView)
        val searchView = searchItem?.actionView as SearchView

        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                searchView.setQuery("", false)
                searchItem.collapseActionView()

                Toast.makeText(this@TelaInicialActivity, "Looking for $query", Toast.LENGTH_LONG).show()
                return  true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

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
            progress.visibility = View.VISIBLE
            progress.postDelayed(Runnable { progress.visibility = View.GONE }, 10000)
            Toast.makeText(this, "atualizado", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_config) {
            Toast.makeText(this, "Botão de configurações", Toast.LENGTH_LONG).show()
        } else if (id == android.R.id.home) {
            //Voltar para a tela inicial usando destroy
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

}
