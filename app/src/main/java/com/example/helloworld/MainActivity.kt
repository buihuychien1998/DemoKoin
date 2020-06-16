package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val bookViewModel: BookViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookViewModel.books.observe(this, Observer {
            // handle UI
            var test = ""
           it.forEach {book->
               test += book.name
           }

            tvData.text = test
        })

//        userViewModel.isLoading.observe(this, Observer {
//            // handle UI
//        })
    }
}