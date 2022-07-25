package com.vishnevskiypro.roomstevdza.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.vishnevskiypro.roomstevdza.R
import com.vishnevskiypro.roomstevdza.data.User
import com.vishnevskiypro.roomstevdza.data.UserViewModel
import com.vishnevskiypro.roomstevdza.databinding.FragmentAddBinding

class AddFragment : Fragment(R.id.addFragment) {

    private lateinit var binding: FragmentAddBinding
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonAdd.setOnClickListener {
            insertDataToDatabase()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun insertDataToDatabase() {
        val firstName = binding.firstName.text.toString()
        val secondName = binding.secondName.text.toString()
        val age = binding.age.text

        if (inputCheck(firstName, secondName, age)){
            //Create User Object
            val user = User(0, firstName, secondName, Integer.parseInt(age.toString()))

            //Add to Database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "User Added", Toast.LENGTH_LONG).show()

            //Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_LONG).show()

        }
    }

    private fun inputCheck(firstName: String, secondName: String, age: Editable): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(secondName) && age.isEmpty())
    }

}