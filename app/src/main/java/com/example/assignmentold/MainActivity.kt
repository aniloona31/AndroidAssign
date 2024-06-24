package com.example.assignmentold

import com.example.assignmentold.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.assignmentold.Fragments.GridListFragment
import com.example.assignmentold.Fragments.LinearListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.itemIconTintList = null

        val linearListFragment = LinearListFragment()
        val gridListFragment = GridListFragment()

        setCurrentFragment(linearListFragment)

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.linearListFragment->setCurrentFragment(linearListFragment)
                R.id.gridListFragment->setCurrentFragment(gridListFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        // Get a reference to the FragmentManager
        val fragmentManager = supportFragmentManager

        // Start a new FragmentTransaction
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Replace the current fragment with the new fragment
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)

        // Commit the FragmentTransaction
        fragmentTransaction.commit()
    }


}

