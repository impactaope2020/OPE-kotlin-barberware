package br.com.wilsonalves.opebarberware

import android.app.Application
import java.lang.IllegalStateException

class BarberwareApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: BarberwareApplication? = null

        fun getInstance(): BarberwareApplication {
            if(appInstance == null){
                throw IllegalStateException("Configurar application no manifest")
            }
            return appInstance!!
        }
    }
}