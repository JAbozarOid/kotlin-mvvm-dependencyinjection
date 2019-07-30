package com.example.androidkotlinmvvmdi.model

// this means model class
// this class is responsible to store data
// val means immutable which it doesn't change and it also public
data class Quote(val quote: String, val author: String) {

    override fun toString(): String {
        return "$quote - $author"
    }
}