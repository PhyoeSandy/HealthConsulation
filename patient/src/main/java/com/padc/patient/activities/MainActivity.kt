package com.padc.patient.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padc.patient.R
import com.padc.patient.fragments.AppointmentsFragment
import com.padc.patient.fragments.HomeFragment
import com.padc.patient.fragments.ProfileFragment
import com.padc.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private var homeFragment = HomeFragment.newInstance()
    private var appointmentsFragment = AppointmentsFragment.newInstance()
    private var profileFragment = ProfileFragment.newInstance()
    private var activeFragment: Fragment = HomeFragment.newInstance()
    
    companion object{
        fun newIntent(context: Context) : Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupFragmentManager()
        callFragment(homeFragment)
        setUpBottomNavigation()
    }

    private fun setUpBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.home ->{callFragment(homeFragment)
                        return true}
                    R.id.appointments ->{callFragment(appointmentsFragment)
                        return true}
                    R.id.profile ->{callFragment(profileFragment)
                        return true}
                }
                return false
            }
        })
    }

    private fun setupFragmentManager() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.container,homeFragment,getString(R.string.home)).hide(homeFragment)
            add(R.id.container,appointmentsFragment,getString(R.string.appointments)).hide(appointmentsFragment)
            add(R.id.container,profileFragment,getString(R.string.profile)).hide(profileFragment)
        }.commit()
    }

    fun callFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().hide(activeFragment).show(fragment).commit()
        activeFragment = fragment
    }

}