package production.zhandos.myapplication.profile

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import production.zhandos.myapplication.room.FollowDao
import production.zhandos.myapplication.room.User
import production.zhandos.myapplication.room.UserDao

class ProfileViewModel(userDao: UserDao,
                       followDao: FollowDao) : ViewModel() {
    var user: LiveData<User> = Transformations.map(userDao.getActivity()) {it}
    var followers: LiveData<Long> =
        Transformations.map(followDao.getFollowersCount(user.value?.id ?: -1)) { it ?: 0L }
    var following: LiveData<Long> =
        Transformations.map(followDao.getFollowingsCount(user.value?.id ?: -1)) { it ?: 0L }

}