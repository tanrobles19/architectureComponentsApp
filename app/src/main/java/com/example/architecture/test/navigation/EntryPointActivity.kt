package com.example.architecture.test.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.architecture.test.R
import com.example.architecture.test.databinding.ActivityMainBinding

class EntryPointActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_container) as NavHostFragment? ?: return

        // Set up Action Bar
        navController = host.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)

        setupActionBarWithNavController(navController, appBarConfiguration)

    }// end fun onCreate()

    override fun onSupportNavigateUp(): Boolean {
        return navController
            .navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}