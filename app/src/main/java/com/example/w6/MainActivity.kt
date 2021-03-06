package com.example.w6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.w6.adapter.ViewPagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var mViewPager: ViewPager
    var navigationView: BottomNavigationView? = null
    var regBack: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewPager = findViewById<ViewPager>(R.id.view_pagerrr)
        navigationView = findViewById(R.id.bottom_nav)
        setUpViewPager()

        navigationView?.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragment_1 -> mViewPager.setCurrentItem(0);
                R.id.fragment_2 -> mViewPager.setCurrentItem(1);
            }
            true
        })
    }

    private fun setUpViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(
            supportFragmentManager,
            FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        mViewPager.setAdapter(viewPagerAdapter);

        //vuốt
        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> navigationView?.getMenu()?.findItem(R.id.fragment_1)?.setChecked(true)
                    1 -> navigationView?.getMenu()?.findItem(R.id.fragment_2)?.setChecked(true)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

    }
}