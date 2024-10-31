package com.example.library.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.library.R

private const val ARG_USERNAME = "username"
private const val ARG_PRIVILEGE = "privilege"

class LeftUserFragment : Fragment() {
    private var username: String? = null
    private var privilege: String? = null
    private lateinit var searchBtn: Button
    private lateinit var displayBtn: Button
    private lateinit var wishlistBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            username = it.getString(ARG_USERNAME)
            privilege = it.getString(ARG_PRIVILEGE)
        }
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_left_user, container, false)

        searchBtn = view.findViewById(R.id.searchBtn)
        displayBtn = view.findViewById(R.id.showBooksBtn)
        wishlistBtn = view.findViewById(R.id.wishlistBtn)
        searchBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Search button clicked", Toast.LENGTH_SHORT).show()
            val searchFragment = SearchFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.rightpanel, SearchFragment())
                .addToBackStack(null)
                .commit()
        }
        displayBtn.setOnClickListener {
            val displayFragment = DisplayFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.rightpanel, DisplayFragment())
                .addToBackStack(null)
                .commit()
        }
        wishlistBtn.setOnClickListener {
            val wishlistFragment = UserWishListFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.rightpanel, wishlistFragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }


}
