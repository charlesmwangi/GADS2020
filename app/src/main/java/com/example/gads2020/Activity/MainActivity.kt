package com.example.gads2020.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.gads2020.R
import androidx.viewpager.widget.ViewPager
import com.example.gads2020.Adapter.MyAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        title = "LEADERBOARD"
        tabLayout.addTab(tabLayout.newTab().setText("Learning Leaders"))
        tabLayout.addTab(tabLayout.newTab().setText("Skill IQ Leaders"))

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = MyAdapter(this, supportFragmentManager,
            tabLayout.tabCount)

        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //Inflate the menu and add the items
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.submit -> {
                val intent = Intent(this, SubmitProject::class.java)
                startActivity(intent)
            true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
