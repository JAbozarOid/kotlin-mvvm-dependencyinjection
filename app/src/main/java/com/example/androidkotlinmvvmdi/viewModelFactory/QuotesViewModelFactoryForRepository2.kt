package com.example.androidkotlinmvvmdi.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidkotlinmvvmdi.repository.QuoteRepository2
import com.example.androidkotlinmvvmdi.viewModel.QuoteViewModelForRepository2

@Suppress("UNCHECKED_CAST")
class QuotesViewModelFactoryForRepository2(private val quoteRepository2: QuoteRepository2) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuoteViewModelForRepository2(quoteRepository2) as T
    }
}