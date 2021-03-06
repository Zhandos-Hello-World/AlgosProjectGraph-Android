package production.zhandos.myapplication.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import production.zhandos.myapplication.room.FollowDao
import production.zhandos.myapplication.room.UserDao

class ProfileViewModelFactory(var id: Long, var dao: UserDao, var followDao: FollowDao): ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(id, dao, followDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}