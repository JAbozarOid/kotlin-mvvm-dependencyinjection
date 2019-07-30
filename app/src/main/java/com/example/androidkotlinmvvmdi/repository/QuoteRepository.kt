package com.example.androidkotlinmvvmdi.repository

import com.example.androidkotlinmvvmdi.model.FakeQuoteDao
import com.example.androidkotlinmvvmdi.model.Quote

// this class is also can be a singleton
// this class is a connection between database and viewmodels
/**
 * we passes FakeQuoteDao to the constructor of the class we aren't creating FakeQuoteDao instance right inside of the repository, we will create it somewhere else
 * this is the core idea behind the dependency injection which is to make things completely modular and independent of each other -> as much as possible
 * don't create dependencies right inside of the class but make them to be pass to the constructor of the class
 */

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao) {

    companion object {
        @Volatile
        private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao) = instance ?: synchronized(this) {
            instance ?: QuoteRepository(quoteDao).also { instance = it } // it means database instance
        }
    }

    fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes() // it return a livedata
}