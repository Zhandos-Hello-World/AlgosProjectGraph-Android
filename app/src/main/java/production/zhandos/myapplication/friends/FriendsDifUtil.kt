package production.zhandos.myapplication.friends

import androidx.recyclerview.widget.DiffUtil
import production.zhandos.myapplication.room.User

class FriendsDifUtil: DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}