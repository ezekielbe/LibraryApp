package com.example.library.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.library.R
import com.example.library.model.Book

class BookAdapter(
    private val books: List<Book>,
    private val itemClickListener: (Book) -> Unit
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val bookTitleTxt: TextView = view.findViewById(R.id.bookTitleTxt)
        private val bookDescTxt: TextView = view.findViewById(R.id.bookDescTxt)


        fun bind(book: Book, itemClickListener: (Book) -> Unit) {
            bookTitleTxt.text = book.title
            bookDescTxt.text = book.description
            itemView.setOnClickListener { itemClickListener(book) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position], itemClickListener)
    }
}
