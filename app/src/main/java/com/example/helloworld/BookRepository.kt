package com.example.helloworld

class BookRepository(val apiService: ApiService) {
    fun getAllBooks() = apiService.getBooks()
}