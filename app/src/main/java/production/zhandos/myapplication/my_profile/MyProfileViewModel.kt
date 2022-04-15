package production.zhandos.myapplication.my_profile

import androidx.lifecycle.*
import production.zhandos.myapplication.room.FollowDao
import production.zhandos.myapplication.room.User
import production.zhandos.myapplication.room.UserDao

class MyProfileViewModel(userDao: UserDao,
                         followDao: FollowDao) : ViewModel() {
    var user: LiveData<User> = Transformations.map(userDao.getActivity()) {it}
    var followers: LiveData<Long> =
        Transformations.map(followDao.getFollowersCount(user.value?.id ?: -1)) { it ?: 0L }
    var following: LiveData<Long> =
        Transformations.map(followDao.getFollowingsCount(user.value?.id ?: -1)) { it ?: 0L }

}