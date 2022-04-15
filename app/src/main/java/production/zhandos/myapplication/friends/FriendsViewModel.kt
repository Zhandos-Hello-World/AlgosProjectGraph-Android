package production.zhandos.myapplication.friends

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import production.zhandos.myapplication.room.Follow
import production.zhandos.myapplication.room.FollowDao
import production.zhandos.myapplication.room.UserDao

class FriendsViewModel(private val dao: UserDao, private val followDao: FollowDao): ViewModel() {
    val following = dao.getFollowings()



    fun unfollow(id: Long) {
        viewModelScope.launch {
            val user = dao.getActivities()[0]
            followDao.deleteCustom(user.id, id)
        }

    }
}