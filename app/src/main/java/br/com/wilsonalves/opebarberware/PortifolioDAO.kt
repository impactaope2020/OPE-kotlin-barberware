package br.com.wilsonalves.opebarberware

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface PortifolioDAO {

    @Query("SELECT * FROM portifolio where id = :id")
    fun getById(id: Long): Portifolio?

    @Query("SELECT * FROM portifolio")
    fun findAll(): List<Portifolio>

    @Insert
    fun insert(disciplina: Portifolio)

    @Delete
    fun delete(disciplina: Portifolio)
}