package br.com.positivo.exam.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModelProvider
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
        supportActionBar?.setDisplayShowTitleEnabled(false)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        initObservers()
        initListeners()
    }

    private fun initObservers() {
        viewModel.getResult().observe(this, {
            binding.textviewResult.text = it
        })
    }

    private fun initListeners() {
        with(binding) {
            execute.setOnClickListener {
                viewModel.executeOperator(
                    edittextInputFirst.text.toString(),
                    edittextInputSecond.text.toString(),
                    xorHex.isChecked)
            }

            xorHex.setOnClickListener {
                viewModel.resetOutput()
            }

            orHex.setOnClickListener {
                viewModel.resetOutput()
            }

            edittextInputFirst.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int,
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    viewModel.resetOutput()
                }
            })

            edittextInputSecond.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int,
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    viewModel.resetOutput()
                }
            })
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }

}