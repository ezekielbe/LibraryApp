package com.example.library.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.library.R
import com.example.library.adapters.BookAdapter
import com.example.library.api.ApiClient
import com.example.library.model.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisplayFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bookAdapter: BookAdapter
    private val bookList = mutableListOf<Book>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_display, container, false)

        recyclerView = view.findViewById(R.id.userRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        bookAdapter = BookAdapter(bookList) { book ->
            val fragment = UserItemDetailFragment.newInstance(
                book.title,
                book.description,
                book.author,
                book.available
            )

            parentFragmentManager.beginTransaction()
                .replace(R.id.rightpanel, fragment)
                .addToBackStack(null)
                .commit()
        }
        recyclerView.adapter = bookAdapter

        recyclerView.adapter = bookAdapter

        fetchBooks()

        return view
    }

    private fun fetchBooks() {
        ApiClient.apiService.getBooks().enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                if (response.isSuccessful) {
                    response.body()?.let { books ->
                        bookList.clear()
                        bookList.addAll(books)
                        bookAdapter.notifyDataSetChanged()
                        Toast.makeText(requireContext(), "Books fetched successfully", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(requireContext(), "Failed to fetch books", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
