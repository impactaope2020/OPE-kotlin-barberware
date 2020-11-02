package br.com.wilsonalves.opebarberware

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Portifolio::class), version = 1)
abstract class BarberDatabase: RoomDatabase() {
    abstract fun portifolioDAO(): PortifolioDAO
}