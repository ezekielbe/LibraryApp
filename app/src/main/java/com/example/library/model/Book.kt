package com.example.library.model

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val genre: String,
    val description: String,
    val quantity: Int,
    val available: Boolean
)
