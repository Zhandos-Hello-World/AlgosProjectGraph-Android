package production.zhandos.myapplication.follow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import production.zhandos.myapplication.databinding.ItemFollowPersonBinding
import production.zhandos.myapplication.room.User

class FollowListAdapter(private var listener: (id: Long) -> Unit,
                        private var followListener: (id: Long) -> Unit):
    ListAdapter<User, FollowListAdapter.FollowViewHolder>(FollowDifUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowViewHolder {
        return FollowViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: FollowViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, listener, followListener)
    }


    class FollowViewHolder(var binding: ItemFollowPersonBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User, listener: (id: Long) -> Unit, followListener: (id: Long) -> Unit) {
            binding.user = user
            binding.unfollow.setOnClickListener {
                followListener((binding.user as User).id)
            }
            binding.root.setOnClickListener {
                listener((binding.user as User).id)
            }
        }

        companion object {
            fun inflate(parent: ViewGroup): FollowViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemFollowPersonBinding.inflate(layoutInflater, parent, false)
                return FollowViewHolder(binding)
            }
        }
    }
}