package com.rosales.adoptame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import android.view.LayoutInflater
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navigationView: NavigationView
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation()
        setupNavigationView()

    }

    private fun setupNavigationView() {
        navigationView = findViewById(R.id.nav_view)
        navigationView.setupWithNavController(navController)
        navigationView.setNavigationItemSelectedListener (this)
        fillNavigationView()
    }

    private fun fillNavigationView() {
        val header = navigationView.getHeaderView(0)
        val username: TextView = header.findViewById(R.id.username_text_view)
        val email: TextView = header.findViewById(R.id.email_text_view)
        username.text = "DiegoFlamenco"
        email.text = "00221020@gmail.com"

        navigationView.menu.clear()

        navigationView.inflateMenu(R.menu.main_menu)
    }

    private fun setupNavigation() {

        val toolBar: MaterialToolbar = findViewById(R.id.main_toolbar)
        setSupportActionBar(toolBar)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_real)
                as NavHostFragment
        navController = navHostFragment.navController
        drawerLayout = findViewById(R.id.main_drawer_layout)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.petMainActivity,
                R.id.petCardListFragment1,
                R.id.shelterCardListFragment,
                R.id.serviceCardListFragment,
                R.id.petPostFragment

            ),
            drawerLayout
        )

        setupActionBarWithNavController(navController,appBarConfiguration)

    }



    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_logout -> {
                //TODO: DO LOGOUT
                true
            } else ->{
                val handle = NavigationUI.onNavDestinationSelected(item, navController)
                if(handle) drawerLayout.close()
                handle
            }
        }
    }


}