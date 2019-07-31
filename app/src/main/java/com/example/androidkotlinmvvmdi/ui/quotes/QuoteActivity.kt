package com.example.androidkotlinmvvmdi.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androidkotlinmvvmdi.R
import com.example.androidkotlinmvvmdi.model.Quote
import com.example.androidkotlinmvvmdi.viewModel.QuoteViewModelForRepository2
import com.example.androidkotlinmvvmdi.viewModelFactory.QuotesViewModelFactoryForRepository2
import kotlinx.android.synthetic.main.activity_main.button_add_quote
import kotlinx.android.synthetic.main.activity_main.textView_quotes
import kotlinx.android.synthetic.main.activity_quote.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class QuoteActivity : AppCompatActivity(), KodeinAware {

    // before inject quoteRepository2 with kodein di first we instantiated as normal way -> declare factory class
    // private val factory: QuotesViewModelFactoryForRepository2 = QuotesViewModelFactoryForRepository2()

    // when something is lazy use "by"
    override val kodein by closestKodein()
    // *** we don't directly instantiated QuotesViewModelFactoryForRepository2 when use kodein
    private val factory: QuotesViewModelFactoryForRepository2 by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)
        initializeUi()
    }

    private fun initializeUi() {
        // use ViewModelProviders class to create / get already created QuotesViewModel
        // for this view (activity)
        val viewModel = ViewModelProviders.of(this, factory).get(QuoteViewModelForRepository2::class.java)

        // Observing LiveData from the QuotesViewModel which in turn observes
        // LiveData from the repository, which observes LiveData from the DAO
        viewModel.getQuotes().observe(this, Observer {
            val stringBuilder = StringBuilder()
            it.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        // when button is clicked, instantiate a Quote and add it to DB through the ViewModel
        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuotes(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}