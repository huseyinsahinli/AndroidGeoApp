package com.hsynshnl.geometriccalculation


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import java.security.AccessController

class MainActivity : AppCompatActivity(){
    private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationController=Navigation.findNavController(this,R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this,navigationController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navigationController,null)
    }




}