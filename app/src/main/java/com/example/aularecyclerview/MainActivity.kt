package com.example.aularecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.aularecyclerview.adapter.FragmentPagerViewAdapter
import com.example.aularecyclerview.adapter.MainAdapter
import com.example.aularecyclerview.fragments.ConversasFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_conversas.*
import kotlinx.android.synthetic.main.modelo_de_tela.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// NÃO SEI SE É CORRETO DIZER QUE ESTAMOS INSTANCIANDO O TABLAYOUT E O VIEW PAGER AQUI
//MAS ESTAMOS FAZENDO COM QUE OS DOIS TRABALHEM JUNTOS....


        val tableLayout = findViewById<TabLayout>(R.id.tab_layoutID)
        val viewPager = findViewById<ViewPager>(R.id.view_PagerID)
        var adapter = FragmentPagerViewAdapter(this, this.supportFragmentManager)
        viewPager.adapter = adapter
        tableLayout.setupWithViewPager(viewPager)

    }
}
