package production.zhandos.myapplication.friends

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import production.zhandos.myapplication.recommend.RecommendViewModel
import production.zhandos.myapplication.room.FollowDao
import production.zhandos.myapplication.room.UserDao

class FriendsViewModelFactory(private val dao: UserDao, private val followDao: FollowDao): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FriendsViewModel::class.java)) {
            return FriendsViewModel(dao, followDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}