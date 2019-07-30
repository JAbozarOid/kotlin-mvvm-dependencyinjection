package com.example.androidkotlinmvvmdi.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * The only difference between the two is communicating your intent.

 * When you write val a = mutableListOf(), you're saying "I want a mutable list, and I don't particularly care about the implementation". When you write, instead, val a = ArrayList(), you're saying "I specifically want an ArrayList".

 * In practice, in the current implementation of Kotlin compiling to the JVM, calling mutableListOf will produce an ArrayList, and there's no difference in behaviour: once the list is built, everything will behave the same.

 * Now, let's say that a future version of Kotlin changes mutableListOf to return a different type of list.

 * Likelier than not, the Kotlin team would only make that change if they figure the new implementation works better for most use cases. mutableListOf would then have you using that new list implementation transparently, and you'd get that better behaviour for free. Go with mutableListOf if that sounds like your case.

 * On the other hand, maybe you spent a bunch of time thinking about your problem, and figured that ArrayList really is the best fit for your problem, and you don't want to risk getting moved to something sub-optimal. Then you probably want to either use ArrayList directly, or use the arrayListOf factory function (an ArrayList-specific analogue to mutableListOf).
 */
class FakeQuoteDao {

    private val quoteList = mutableListOf<Quote>() // empty list by default

    // observe this quotes from that repository and also in viewmodel observe this quotes through the repository
    // with Mutable we want to be able to change the value of this livedata from this fake dao class
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value =
            quoteList // with this line we can immediately that connect the empty list quoteList to mutablelivedata which can observe from our classes
    }

    fun addQuote(quote: Quote) {
        quoteList.add(quote)
        // after the list is updated the observable data also get updated, and when the values is updated it will trigger the observers for this mutablelivedata in all of the classes which are observe it
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<Quote>> // we cast because we don't want to be able to change the value of the livedata outside of the fakedao class, outside we just want to be able to observe it

}