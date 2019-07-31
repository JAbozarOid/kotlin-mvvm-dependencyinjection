package com.example.androidkotlinmvvmdi

import android.app.Application
import com.example.androidkotlinmvvmdi.db.Database
import com.example.androidkotlinmvvmdi.db.DatabaseFakeImpl
import com.example.androidkotlinmvvmdi.db.QuoteDao
import com.example.androidkotlinmvvmdi.repository.QuoteRepository2
import com.example.androidkotlinmvvmdi.repository.QuoteRepositoryImplForQuoteRepository2
import com.example.androidkotlinmvvmdi.viewModelFactory.QuotesViewModelFactoryForRepository2
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class QuotesApplication : Application(), KodeinAware {

    // it is initialize only once the application is ready to go, when the oncreate has run -> lazy
    override val kodein: Kodein = Kodein.lazy {
        // our database must be singleton and doesn't make sense to have multiple instances of our database class
        // with is a infix fun and it means infix function in kotlin doesn't need dot or "."
        bind<Database>() with singleton { DatabaseFakeImpl() }

        // we can get access the QuoteDao by instantiated QuoteDaoFakeImpl but we use instance<>().quoteDao and get it from database
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }

        // QuoteRepository need QuoteDao so we defined in the line above and we can pass this line bind<QuoteDao>() with singleton { instance<Database>().quoteDao } by instance()
        bind<QuoteRepository2>() with singleton { QuoteRepositoryImplForQuoteRepository2(instance()) }

        // for viewmodelfactory we do not have interface so we concrete the class by provider and provider is opposite of singleton
        bind<QuotesViewModelFactoryForRepository2>() with provider { QuotesViewModelFactoryForRepository2(instance()) }
    }
}