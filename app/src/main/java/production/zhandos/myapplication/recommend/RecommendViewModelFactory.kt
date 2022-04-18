package production.zhandos.myapplication.recommend

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import production.zhandos.myapplication.room.FollowDao
import production.zhandos.myapplication.room.UserDao

class RecommendViewModelFactory(private val dao: UserDao, private val followDao: FollowDao):
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecommendViewModel::class.java)) {
            return RecommendViewModel(dao, followDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}