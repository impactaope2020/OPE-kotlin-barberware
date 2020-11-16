package br.com.wilsonalves.opebarberware

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "portifolio")
class Portifolio: Serializable {
    @PrimaryKey
    var id: Long = 0
    var descricao = ""
    var imagem = ""

    override fun toString(): String {
        return "Descrição(descricao='$descricao')"
    }

}