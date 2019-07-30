package com.example.androidkotlinmvvmdi.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidkotlinmvvmdi.repository.QuoteRepository
import com.example.androidkotlinmvvmdi.viewModel.QuotesViewModel

/**
 * we need some kind of viewmodel provider that it will check is the repository or actually viewmodel already present in the memory
 * if already present in the memory , we are going to pass it back to the activities so the data in the viewmodel will not be reset
 * if it is the first time the activity or fragment is requesting a viewmodel we are going to create an instance and pass it back to theirs
 * because of a viewmodel provider instantiated our viewmodels requires viewmodel factory, so we can not simply create viewmodels directly and instead we are going to recreated that factory
 */

class QuotesViewModelFactory(private val quoteRepository: QuoteRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}