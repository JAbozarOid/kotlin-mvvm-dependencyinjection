package com.example.androidkotlinmvvmdi.viewModel

import androidx.lifecycle.ViewModel
import com.example.androidkotlinmvvmdi.model.Quote
import com.example.androidkotlinmvvmdi.repository.QuoteRepository2

/**
 * this class is different with QuotesViewModel because that viewmodel class inherite from a concrete repository instead this class inherite an interface repository QuoteRepository2
 */
class QuoteViewModelForRepository2(private val quoteRepository2: QuoteRepository2) : ViewModel() {

    fun addQuotes(quote: Quote) = quoteRepository2.addQuote(quote)
    fun getQuotes() = quoteRepository2.getQuotes()
}