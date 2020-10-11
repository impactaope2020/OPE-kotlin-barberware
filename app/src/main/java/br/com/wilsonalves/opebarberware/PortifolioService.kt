package br.com.wilsonalves.opebarberware

object PortifolioService {
    fun getPortifolio():List<Portifolio> {
        val portifolios = mutableListOf<Portifolio>()
        for (i in 1..10) {
            val p = Portifolio()
            p.descricao = "Descrição $i"
            p.foto = "https://a-static.mlcdn.com.br/618x463/relogio-de-vinil-disco-lp-parede-barber-shop-barbearia-3d-fantasy/3dfantasy/df66c6d87cca11ea8db64201ac18501e/3f3a9ac81e5f89f8b564cdbe93330f19.jpg"
            p.barbeiro = "Barbeiro $i"

            portifolios.add(p)
        }
        return portifolios
    }
}