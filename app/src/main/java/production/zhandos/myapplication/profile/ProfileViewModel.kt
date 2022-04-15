package production.zhandos.myapplication.profile

import androidx.lifecycle.ViewModel
import production.zhandos.myapplication.room.FollowDao
import production.zhandos.myapplication.room.UserDao

class ProfileViewModel(var id: Long, var dao: UserDao, var followDao: FollowDao): ViewModel() {
    val user = dao.getById(id)

}