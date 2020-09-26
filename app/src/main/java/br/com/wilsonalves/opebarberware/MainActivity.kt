package br.com.wilsonalves.opebarberware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.login.textoInicial

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)


        imgLogin.setImageResource(R.drawable.img_logo)
        textoInicial.setText(R.string.mensagem_login)

        botaoLogin.setOnClickListener{
            val valorUsuario = campoUsuario.text.toString()
            var valorSenha  = campoSenha.text.toString()
            Toast.makeText(this, "Usuário $valorUsuario; Senha $valorSenha", Toast.LENGTH_LONG).show()
        }


        background.getBackground().setAlpha(128);
    }
}