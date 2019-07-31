package com.example.androidkotlinmvvmdi.repository

import androidx.lifecycle.LiveData
import com.example.androidkotlinmvvmdi.model.Quote

interface QuoteRepository2 {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}