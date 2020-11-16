package br.com.wilsonalves.opebarberware

import android.content.Intent
import android.util.Log
import br.com.wilsonalves.lmsapp.Prefs
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {
    val TAG = "firebase"

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.d(TAG, "Novo token: $token")
        // guarda token em SharedPreferences
        Prefs.setString("FB_TOKEN", token!!)
    }

    // recebe a notificação de push
    override fun onMessageReceived(mensagemRemota: RemoteMessage?) {
        Log.d(TAG, "onMessageReceived")

        // verifica se a mensagem recebida do firebase é uma notificação
        if (mensagemRemota?.notification != null) {
            val titulo = mensagemRemota?.notification?.title
            val corpo = mensagemRemota?.notification?.body
            Log.d(TAG, "Titulo da mensagem: $titulo")
            Log.d(TAG, "Corpo da mensagem: $corpo")

            if(mensagemRemota?.data.isNotEmpty()) {
                val intent = Intent(this, CadastrarAgendamentoActivity::class.java)

                val agendamentoId = mensagemRemota?.data.get("agendamentoId")
                NotificationUtil.create(1, intent, titulo!!, agendamentoId!!)
            }
//            showNotification(mensagemRemota)
        }
    }

//    private fun showNotification(mensagemRemota: RemoteMessage) {
//
//        // Intent para abrir quando clicar na notificação
//        val intent = Intent(this, PortifolioActivitiy::class.java)
//        // se título for nulo, utilizar nome no app
//        val titulo = mensagemRemota?.notification?.title?: getString(R.string.app_name)
//        var mensagem = mensagemRemota?.notification?.body!!
//
//        // verificar se existem dados enviados no push
//        if(mensagemRemota?.data.isNotEmpty()) {
//            val portifolioId = mensagemRemota.data.get("portifolioId")?.toLong()!!
//            mensagem += ""
//            // recuperar disciplina no WS
//            val portifolio = PortifolioService.getPortifolio(this, id)
//            intent.putExtra("portifolio", portifolio)
//        }
//        NotificationUtil.create(1, intent,
//            "Mensagem Recebida", "Aguarde logo entraremos em contato")
//    }
}