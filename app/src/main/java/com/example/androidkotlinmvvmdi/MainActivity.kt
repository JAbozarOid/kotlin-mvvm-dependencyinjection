package com.example.androidkotlinmvvmdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androidkotlinmvvmdi.model.Quote
import com.example.androidkotlinmvvmdi.utilities.InjectorUtils
import com.example.androidkotlinmvvmdi.viewModel.QuotesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUi()
    }

    private fun initializeUi() {
        // 1- all of the dependencies are created in the injector utiles so we don't worry about anything
        val factory = InjectorUtils.provideQuotesViewModelFactory()

        // 2-
        val viewModel = ViewModelProviders.of(this, factory).get(QuotesViewModel::class.java)

        // 3- we are going finally to observe livedata from the quotesviewmodel
        viewModel.getQuotes().observe(this, Observer {
            val stringBuilder = StringBuilder()
            it.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        // when button clicked get the texts from edit texts and put it in the databases
        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuotes(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }

    }


}
