package com.example.effectivemoviledbwebtopic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.effectivemoviledbwebtopic.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityBinding: ActivityMainBinding
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    val mainViewModel: MainViewModel by viewModels<MainViewModel> {
        mainViewModelFactory
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        (applicationContext as App).appComponent.injectToActivity(this)
        mainViewModel.countBouquets.observe(this){
            mainActivityBinding.textView.text = it.toString()
        }
        setContentView(mainActivityBinding.root)
    }
}