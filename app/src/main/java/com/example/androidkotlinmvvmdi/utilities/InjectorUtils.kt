package com.example.androidkotlinmvvmdi.utilities

import com.example.androidkotlinmvvmdi.model.FakeDatabase
import com.example.androidkotlinmvvmdi.repository.QuoteRepository
import com.example.androidkotlinmvvmdi.viewModelFactory.QuotesViewModelFactory

// this class is a singleton which doesn't require anything to be pass to its constructor
object InjectorUtils {

    // this function will call from the Quotes activity to get the quotesviewmodelfactory
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        // because of quotesviewmodelfactory need quoteRepository in constructor we declare a variable
        // QuoteRepository is a singleton class that need FakeQuoteDao which is also singleton
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}