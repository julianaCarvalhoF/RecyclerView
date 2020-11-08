package com.example.aularecyclerview.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.aularecyclerview.fragments.ChamadasFragment
import com.example.aularecyclerview.fragments.ConversasFragment

class FragmentPagerViewAdapter (ctx : Context, fm : FragmentManager) : FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            //PEGANDO A POSIÇÃO, NA VERDADE GERANDO ELAS COMEÇANDO PELA 0
            //AQUI PODEMOS NOMEAR AS TABS

            0 -> return "Conversas"
            else -> return "Chamadas"
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        //NESSA PARTE CHAMAMOS O FRAGMENT EM SI, BASEADO NA POSIÇÃO QUE QUEREMOS QUE ELES
        // SEJAM EXIBIDOS

        when(position){
            0 -> return ConversasFragment()
            else -> return ChamadasFragment()
        }
    }
}