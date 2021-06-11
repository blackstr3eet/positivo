package br.com.positivo.exam.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import br.com.positivo.exam.databinding.ActivityMainBinding
import br.com.positivo.exam.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        initObservers()
        initListeners()
    }

    private fun initObservers() {

    }

    private fun initListeners() {

    }
}