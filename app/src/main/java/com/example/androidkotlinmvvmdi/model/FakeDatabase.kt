package com.example.androidkotlinmvvmdi.model

// the primary constructor is private so it can not be invoke outside of this class
// this class is a singleton if you would need to have something pass inside of the constructor
class FakeDatabase private constructor() {

    var quoteDao = FakeQuoteDao()
        private set

    // to get instance of this class we use companion object
    companion object {
        // we need an instance property which can referring single instance that its present currently -> Volatile
        // Volatile means write to this property or immediately visible to other threads
        @Volatile
        private var instance: FakeDatabase? = null

        // this here means  companion object and synchronized two threas can not execute at the same time
        fun getInstance() = instance ?: synchronized(this) {
            // double check to sure the instance have not null
            instance ?: FakeDatabase().also { instance = it } // it means database instance
        }
    }
}