package com.smalllei.jetpackdemo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val main: NavHostFragment =
                supportFragmentManager.findFragmentById(R.id.home_nav_main_fragment) as NavHostFragment
        val bottomNav = findViewById<BottomNavigationView>(R.id.home_bottom_nav)

        val toolbar = findViewById<Toolbar>(R.id.home_toolbar)
        setSupportActionBar(toolbar)
        val navController = main.navController

        setupWithNavMenu(navController, bottomNav)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.home_fragment, R.id.news_fragment, R.id.settings_fragment))
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->

            when {
                destination.id == R.id.home_fragment
                        || destination.id == R.id.news_fragment
                        || destination.id == R.id.settings_fragment -> bottomNav.visibility = View.VISIBLE
                else -> bottomNav.visibility = View.GONE

            }
        }
    }

    private fun setupWithNavMenu(navController: NavController, bottomNav: BottomNavigationView) {
        bottomNav.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.home_nav_main_fragment).navigateUp(appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val retValue = super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.bottom_nav_menu, menu)
        return retValue
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //return super.onOptionsItemSelected(item)
        return item.onNavDestinationSelected(findNavController(R.id.home_nav_main_fragment)) || super.onOptionsItemSelected(item)
    }

}
