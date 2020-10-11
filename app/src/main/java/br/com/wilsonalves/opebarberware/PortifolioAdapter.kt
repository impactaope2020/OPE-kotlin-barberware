package br.com.wilsonalves.opebarberware

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PortifolioAdapter (
    val portifolio: List<Portifolio>,
    val onClick: (Portifolio) -> Unit
): RecyclerView.Adapter<PortifolioAdapter.PortifolioViewHolder>() {

    class  PortifolioViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardDescricao: TextView
        val cardImg: ImageView
        val cardProgress: ProgressBar

        init {
            cardDescricao = view.findViewById(R.id.cardDescricao)
            cardImg = view.findViewById(R.id.cardImg)
            cardProgress = view.findViewById(R.id.cardProgress)
        }
    }

    override fun getItemCount() = this.portifolio.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortifolioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_portifolio, parent, false)

        val holder = PortifolioViewHolder(view)

        return holder
    }

    override fun onBindViewHolder(holder: PortifolioViewHolder, posicao: Int) {
        val portifolio = this.portifolio[posicao]

        holder.cardDescricao.text = portifolio.descricao
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(holder.itemView.context).load(portifolio.foto).fit().into(holder.cardImg,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            })

        holder.itemView.setOnClickListener {
            onClick(portifolio)
        }
    }
}