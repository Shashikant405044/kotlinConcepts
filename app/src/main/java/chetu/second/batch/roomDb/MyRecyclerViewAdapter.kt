package chetu.second.batch.roomDb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import chetu.second.batch.kotlinconcepts.databinding.ListItemsBinding
import chetu.second.batch.roomDb.db.User

class MyRecyclerViewAdapter(private val userList: List<User>, var selectedItem:(User) -> Unit) : RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        val binding = ListItemsBinding.inflate(layoutInflator, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position], selectedItem)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}

class MyViewHolder(val binding : ListItemsBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(user: User, selectedItem: (User) -> Unit){
        binding.tvName.text = user.firstName+" "+user.lastName
        binding.tvMobileNo.text = user.mobileNo
        binding.rootItem.setOnClickListener {
            selectedItem(user)
        }
    }
}