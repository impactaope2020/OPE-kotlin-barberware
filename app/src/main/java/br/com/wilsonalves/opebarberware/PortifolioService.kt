package br.com.wilsonalves.opebarberware

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.net.URL

object PortifolioService {
    val host = "http://127.0.0.1:5000"
    val TAG = "WS_LMSApp"
    fun getPortifolio(context: Context): List<Portifolio> {
//        val portifolios = mutableListOf<Portifolio>()
//        for (i in 1..10) {
//            val p = Portifolio()
//            p.descricao = "Descrição $i"
//            p.foto = "https://a-static.mlcdn.com.br/618x463/relogio-de-vinil-disco-lp-parede-barber-shop-barbearia-3d-fantasy/3dfantasy/df66c6d87cca11ea8db64201ac18501e/3f3a9ac81e5f89f8b564cdbe93330f19.jpg"
//            p.barbeiro = "Barbeiro $i"
//
//            portifolios.add(p)
//        }
//        return portifolios

//        val url = "$host/disciplinas"
//        val json = HttpHelper.get(url)
//
//        Log.d(TAG, json)
//
//        return parserJson<List<Portifolio>>(json)

        val dao = DatabaseManager.getPortifolioDAO()
        return dao.findAll()
    }
    fun save(portifolio: Portifolio) {
//        HttpHelper.post("$host/disciplinas",
//            GsonBuilder().create().toJson(portifolio)
//        )
        val dao = DatabaseManager.getPortifolioDAO()
        return dao.insert(portifolio)
    }
    inline fun<reified T> parserJson(json: String) : T {
        val type = object: TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}