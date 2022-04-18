package production.zhandos.myapplication.find

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import production.zhandos.myapplication.room.Follow
import production.zhandos.myapplication.room.FollowDao
import production.zhandos.myapplication.room.UserDao

class FindViewModel(private val dao: UserDao, private val followDao: FollowDao): ViewModel() {
    val search = MutableLiveData("")
    val notActive = dao.getNotFollowings()



    fun follow(id: Long) {
        viewModelScope.launch {
            val user = dao.getActivities()[0]
            val follow = Follow(first_id = user.id, second_Id = id)
            followDao.insert(follow)

        }
    }
}