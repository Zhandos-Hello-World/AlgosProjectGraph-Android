package production.zhandos.myapplication.follow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import production.zhandos.myapplication.room.FollowDao
import production.zhandos.myapplication.room.UserDao

class FollowViewModel(private val dao: UserDao, private val followDao: FollowDao) : ViewModel() {
    val following = dao.getFollowings()
    val followers = dao.getFollowers()


    fun unfollow(id: Long) {
        viewModelScope.launch {
            val user = dao.getActivities()[0]
            followDao.deleteCustom(user.id, id)
        }
    }

    fun deleteFromMe(id: Long) {
        viewModelScope.launch {
            val user = dao.getActivities()[0]
            followDao.deleteCustom(id, user.id)
        }
    }
}