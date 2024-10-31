package com.example.library.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.library.R

class UserItemDetailFragment : Fragment() {

    private var bookTitle: String? = null
    private var bookDescription: String? = null
    private var author: String? = null
    private var available: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            bookTitle = it.getString("bookTitle")
            bookDescription = it.getString("bookDescription")
            author = it.getString("author")
            available = it.getBoolean("available")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_item_detail, container, false)

        val bookTitleTxt = view.findViewById<TextView>(R.id.bookTitleTxt)
        val bookDescTxt = view.findViewById<TextView>(R.id.bookDescTxt)
        val authorTxt = view.findViewById<TextView>(R.id.authorTxt)
        val availableTxt = view.findViewById<TextView>(R.id.avalibleTxt)
        val wishlistButton = view.findViewById<Button>(R.id.wishlistBtn)

        bookTitleTxt.text = bookTitle
        bookDescTxt.text = bookDescription
        authorTxt.text = "Author: $author"
        availableTxt.text = if (available) "Available" else "Not Available"

        wishlistButton.setOnClickListener {

        }

        return view
    }

    companion object {
        fun newInstance(bookTitle: String, bookDescription: String, author: String, available: Boolean) =
            UserItemDetailFragment().apply {
                arguments = Bundle().apply {
                    putString("bookTitle", bookTitle)
                    putString("bookDescription", bookDescription)
                    putString("author", author)
                    putBoolean("available", available)
                }
            }
    }
}
