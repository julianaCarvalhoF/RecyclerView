package com.example.aularecyclerview.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aularecyclerview.adapter.MainAdapter
import com.example.aularecyclerview.models.BlogPost
import com.example.aularecyclerview.R
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_conversas.*
import kotlinx.android.synthetic.main.modelo_de_tela.*

class ConversasFragment : Fragment() {

    private fun obterblog(): List<BlogPost> {

        // criando variavel para receber todos os produtos criados

        val blogPost = mutableListOf<BlogPost>()
        val conversa1 = BlogPost(
            "Olá Boa noite!",
            "1",
            "data:image/jpeg;base64,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" ,
            "Juliana C"
        )

        val conversa2 = BlogPost(
            "ok",
            "2",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRovb86cKzgTC1IxdqkGSkp2iw7uao99t7Fbg&usqp=CAU",
            "Carol"
        )

        val conversa3 = BlogPost(
            "Olá Boa noite!",
            "1",
            "data:image/jpeg;base64,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" ,
            "Kate M."
        )

        blogPost.addAll(listOf(conversa1, conversa2,conversa3))

        return blogPost
    }
// AQUI USAMOS O CONCEITO DE INFLAR NOVAMENTE EU ENTENDO COMO SE FOSSE ALGO QUE ESTEJA MUCHO
// DAI ENCHEMOS DE AR KKK OU SEJA LEVANTAMOS ALGO ASSIM DESSA VEZ PASSAMOS O LAYOUT DO PROPRIO FRAGMENT

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conversas, container, false)
    }

    //PASSANDO NOSSA RECYCLE VIU COMO ADPATER DENTRO DO FRAGMENT
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val produtos = obterblog() // peguei todos os itens que criamos acima


        rv_frag.apply {
            setHasFixedSize(true)
            //layoutManeger é uma função que vem junto ao recycle view elas nos ajuda
            //a mexer nele, e aqui escolhemos a exbição em modo linear e passamos o contexto da view

            layoutManager = LinearLayoutManager(view.context)
            adapter = MainAdapter(produtos) {

                //Aqui podemos codar pra chamar algo através do clique

                Log.i("Conversa Fragment", "onViewCreated: clicando no item da pos. $it")
            }
        }
    }
}