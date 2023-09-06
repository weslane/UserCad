package com.mwsa.usercad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.mwsa.usercad.databinding.ActivityMainBinding
import com.raizlabs.android.dbflow.annotation.Database
import com.raizlabs.android.dbflow.config.FlowManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FlowManager.init(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }
}
