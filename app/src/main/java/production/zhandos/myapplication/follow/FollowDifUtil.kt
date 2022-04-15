package production.zhandos.myapplication.follow

import androidx.recyclerview.widget.DiffUtil
import production.zhandos.myapplication.room.User

class FollowDifUtil: DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}