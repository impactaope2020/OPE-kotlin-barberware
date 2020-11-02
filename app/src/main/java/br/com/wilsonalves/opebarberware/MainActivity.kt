package br.com.wilsonalves.opebarberware

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import br.com.wilsonalves.lmsapp.Prefs
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.login.textoInicial

class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        imgLogin.setImageResource(R.drawable.img_logo)
        textoInicial.setText(R.string.mensagem_login)

//        Prefs.setString("nome", "Wilson")

        campoUsuario.setText(Prefs.getString("usuario"))
        campoSenha.setText(Prefs.getString("senha"))
        checkLogin.isChecked = Prefs.getBoolean("lembrar")


        botaoLogin.setOnClickListener{
            onClickLogin()
        }


        background.getBackground().setAlpha(128)
    }
    fun onClickLogin(){
        progress.visibility = View.VISIBLE

        val valorUsuario = campoUsuario.text.toString()
        val valorSenha  = campoSenha.text.toString()
        Toast.makeText(this, "Usuário $valorUsuario", Toast.LENGTH_LONG).show()

        Prefs.setBoolean("lembrar", checkLogin.isChecked)
        if(checkLogin.isChecked){
            Prefs.setString("usuario", valorUsuario)
            Prefs.setString("senha", valorSenha)
        } else {
            Prefs.setString("usuario", "")
            Prefs.setString("senha", "")
        }

        //para criar um tela criamos dentro da pasta java e projeto uma nova Activity
        //uso do intent para criar uma nova tela
//            val intent = Intent(this, TelaInicialActivity::class.java)
        val params = Bundle()
        params.putString("nome_usuario", valorUsuario)
        params.putInt("numero", 10)

        //chamar  login enviando como parametro usuario e senha
        if(valorUsuario.equals("aluno") && valorSenha.equals("impacta")) {
            val intent = Intent(this, TelaInicialActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Login Inválido", Toast.LENGTH_LONG).show()
        }

        intent.putExtras(params)

//            progress.visibility = View.GONE

//            startActivity(intent)
    }
}