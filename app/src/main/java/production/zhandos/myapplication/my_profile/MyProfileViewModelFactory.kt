package production.zhandos.myapplication.my_profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import production.zhandos.myapplication.room.FollowDao
import production.zhandos.myapplication.room.UserDao

class MyProfileViewModelFactory(private val dao: UserDao, private val followDao: FollowDao): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyProfileViewModel::class.java)) {
            return MyProfileViewModel(dao, followDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}