package com.example.androidkotlinmvvmdi.db

/**
 * no dependency injection needed here because DatabaseFakeImpl always want QuoteDaoFakeImpl so it instantiated directory here
 */
class DatabaseFakeImpl : Database {
    override val quoteDao: QuoteDao
        get() = QuoteDaoFakeImpl()
}