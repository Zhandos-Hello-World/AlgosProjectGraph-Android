package production.zhandos.myapplication.find

import androidx.recyclerview.widget.DiffUtil
import production.zhandos.myapplication.room.User

class FindDiffUtil(): DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}