package com.vishnevskiypro.roomstevdza.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vishnevskiypro.roomstevdza.R
import com.vishnevskiypro.roomstevdza.data.User
import com.vishnevskiypro.roomstevdza.databinding.CustomRowBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = CustomRowBinding.bind(itemView)

        fun bind(user: User){
            binding.apply {
                idText.text = user.id.toString()
                firstNameText.text = user.firstName
                lastNameText.text = user.secondName
                ageText.text = user.age.toString()
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position])
    }


    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user : List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}