package com.example.androidkotlinmvvmdi.repository

import androidx.lifecycle.LiveData
import com.example.androidkotlinmvvmdi.db.QuoteDao
import com.example.androidkotlinmvvmdi.model.Quote

class QuoteRepositoryImplForQuoteRepository2(private val quoteDao: QuoteDao) : QuoteRepository2 {

    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    override fun getQuotes(): LiveData<List<Quote>> {
        return quoteDao.getQuotes()
    }
}