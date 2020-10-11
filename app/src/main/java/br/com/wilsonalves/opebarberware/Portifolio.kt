package br.com.wilsonalves.opebarberware

import java.io.Serializable

class Portifolio: Serializable {
    var id: Long = 0
    var descricao = ""
    var foto = ""
    var barbeiro = ""

    override fun toString(): String {
        return "Portifolio(descricao=$descricao)"
    }
}