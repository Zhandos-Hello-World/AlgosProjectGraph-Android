package production.zhandos.myapplication.find

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import production.zhandos.myapplication.room.FollowDao
import production.zhandos.myapplication.room.UserDao

class FindViewModelFactory(private val userDao: UserDao, private val followDao: FollowDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FindViewModel::class.java)) {
            return FindViewModel(userDao, followDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }

}