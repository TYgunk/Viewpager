package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpager.databinding.StartBinding
import com.google.android.material.tabs.TabLayoutMediator

class start : AppCompatActivity() {
    private lateinit var binding: StartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewpager2.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = 4

            override fun createFragment(position: Int) =
                when (position) {
                    0 -> ScaleFragment()
                    1 -> RotateFragment()
                    2 -> BlankFragment()
                    else -> TranslateFragment()
                }
        }
        TabLayoutMediator(binding.tabLayout, binding.viewpager2){tab, position ->
            when(position){

                0-> {
                    tab.icon=getDrawable(R.drawable.account)
                    tab.text="帳戶"
                }
                1-> {
                    tab.icon=getDrawable(R.drawable.message)
                    tab.text="訊息"
                }
                2-> {
                    tab.icon=getDrawable(R.drawable.person_add)
                    tab.text="加好友"
                }
                else ->
                {
                    tab.icon=getDrawable(R.drawable.settings)
                    tab.text="設定"
                }
            }
        }.attach()
    }
}