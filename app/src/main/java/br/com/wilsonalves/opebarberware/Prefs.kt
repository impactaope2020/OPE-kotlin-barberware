package br.com.wilsonalves.lmsapp

import android.content.SharedPreferences
import br.com.wilsonalves.opebarberware.BarberwareApplication

object Prefs {

    private fun prefs(): SharedPreferences{
        val contexto = BarberwareApplication.getInstance().applicationContext
        return contexto.getSharedPreferences("LMS", 0)
    }

    fun getString(flag: String): String? {
        return prefs().getString(flag, "")
    }

    fun setString(flag: String, valor: String) {
        prefs().edit().putString(flag, valor).apply()
    }

    fun getBoolean(flag: String): Boolean {
        return prefs().getBoolean(flag, false)
    }
    fun setBoolean(flag: String, valor: Boolean) {
        prefs().edit().putBoolean(flag, valor).apply()
    }

}