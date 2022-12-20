package com.example.viewpagerwithdynamicfragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var pagerAdapter: FragmentStateAdapter? = null
    private val NUM_PAGES = 5
    private val fragmentData = arrayOf("A", "B", "C", "D", "E")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pagerAdapter = ViewPagerAdapter(this, fragmentData, NUM_PAGES)
        viewpager.adapter = pagerAdapter
        ViewPagerUtil.instance?.setupIndicator(this, viewpager, pager_dots, NUM_PAGES)
        ViewPagerUtil.instance?.onBackPressed(viewpager, supportFragmentManager)
    }

    override fun onBackPressed() {
        setViewPagerBackPress()
    }

    private fun setViewPagerBackPress() {
        if (viewpager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewpager.currentItem = viewpager.currentItem - 1
        }
    }
}