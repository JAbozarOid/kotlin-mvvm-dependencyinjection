package com.example.androidkotlinmvvmdi.db

import androidx.lifecycle.LiveData
import com.example.androidkotlinmvvmdi.model.Quote

// this class is an interface to add stuff or get stuff from our local database
// DAO means data access object
interface QuoteDao {

    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}