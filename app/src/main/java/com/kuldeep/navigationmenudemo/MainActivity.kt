package com.kuldeep.navigationmenudemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.kuldeep.navigationmenudemo.databinding.ActivityMainBinding

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        val drawerLayout: DrawerLayout=findViewById(R.id.sliderLayout)
        val navView: NavigationView=findViewById(R.id.navView)
        toggle= ActionBarDrawerToggle(this,drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home ->binding.currentMenuItem.text="Home"
                R.id.nav_message ->binding.currentMenuItem.text="Message"
                R.id.nav_sync ->binding.currentMenuItem.text="Sync"
                R.id.nav_thrash ->binding.currentMenuItem.text="Trash"
                R.id.nav_setting ->binding.currentMenuItem.text="Setting"
                R.id.nav_login ->binding.currentMenuItem.text="Login"
                R.id.nav_share ->binding.currentMenuItem.text="Share"
                R.id.nav_rateus ->binding.currentMenuItem.text="RateUs"
            }

            drawerLayout.closeDrawers()
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}