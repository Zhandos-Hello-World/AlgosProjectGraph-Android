package production.zhandos.myapplication.follow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import production.zhandos.myapplication.room.FollowDao
import production.zhandos.myapplication.room.UserDao

class FollowViewModelFactory(private val userDao: UserDao, private val followDao: FollowDao):
ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FollowViewModel::class.java)) {
            return FollowViewModel(userDao, followDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }

}