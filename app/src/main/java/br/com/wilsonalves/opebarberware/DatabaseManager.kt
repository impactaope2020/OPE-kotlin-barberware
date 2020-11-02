package br.com.wilsonalves.opebarberware

import androidx.room.Room

object DatabaseManager {
    private var dbInstance: BarberDatabase

    init {
        val context = BarberwareApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            BarberDatabase::class.java,
            "barber.sqlite"
        ).build()
    }
    fun getPortifolioDAO(): PortifolioDAO{
        return dbInstance.portifolioDAO()
    }
}