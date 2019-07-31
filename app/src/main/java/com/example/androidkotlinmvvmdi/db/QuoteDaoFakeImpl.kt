package com.example.androidkotlinmvvmdi.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidkotlinmvvmdi.model.Quote

class QuoteDaoFakeImpl : QuoteDao {


    private val quoteList = mutableListOf<Quote>()

    // this is for observe changes -> cause this value will change is Mutable and cause of change just in this class this is private
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    override fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    override fun getQuotes(): LiveData<List<Quote>> {
        return this.quotes
    }
}