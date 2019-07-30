package com.example.androidkotlinmvvmdi.viewModel

import androidx.lifecycle.ViewModel
import com.example.androidkotlinmvvmdi.model.Quote
import com.example.androidkotlinmvvmdi.repository.QuoteRepository

/**
 * now it's time to connect what we created to the view part of mvvm and in this case the view is the MainActivity
 * all of the logic data and manipulating with data goes to viewmodel and then the view only call the functions on the view model
 */
class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    // we need two functions here one for getting quotes and another for add quotes

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuotes(quote: Quote) = quoteRepository.addQuote(quote)
}