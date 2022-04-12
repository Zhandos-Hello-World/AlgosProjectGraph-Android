package production.zhandos.myapplication.find

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import production.zhandos.myapplication.databinding.ItemPersonBinding
import production.zhandos.myapplication.room.User

class FindListAdapter : ListAdapter<User, FindListAdapter.FindRecyclerViewHolder>(FindDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FindRecyclerViewHolder {
        return FindRecyclerViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: FindRecyclerViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class FindRecyclerViewHolder(private var binding: ItemPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.user = user
        }

        companion object {
            fun inflate(parent: ViewGroup): FindRecyclerViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPersonBinding.inflate(layoutInflater, parent, false)
                return FindRecyclerViewHolder(binding)
            }
        }
    }
}