package com.example.helloworld

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookViewModel(private val bookRepository: BookRepository) : ViewModel(),
    Callback<List<Book>> {
    
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>>
        get() = _books

    init {
        fetchData()
    }

    private fun fetchData() {
        _isLoading.value = true
        bookRepository.getAllBooks().enqueue(this)
    }

    override fun onFailure(call: Call<List<Book>>, t: Throwable) {
        _isLoading.value = false
        // handle error
    }

    override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
        if (response.isSuccessful) {
            _books.value = response.body()
        } else {
           // handle error
        }
        _isLoading.value = false
    }
}