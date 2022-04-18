package production.zhandos.myapplication.recommend

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import production.zhandos.myapplication.room.FollowDao
import production.zhandos.myapplication.room.UserDao

class RecommendViewModel(private val dao: UserDao, private val followDao: FollowDao): ViewModel() {
    val users = dao.getAll()
    val followings = followDao.getAll()


    init {

    }

    //Todo
    fun follow(id: Long) {

    }

}