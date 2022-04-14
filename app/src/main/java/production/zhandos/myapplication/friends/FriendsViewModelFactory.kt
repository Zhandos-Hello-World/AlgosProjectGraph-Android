package production.zhandos.myapplication.friends

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import production.zhandos.myapplication.recommend.RecommendViewModel
import production.zhandos.myapplication.room.UserDao

class FriendsViewModelFactory(private val dao: UserDao): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecommendViewModel::class.java)) {
            return RecommendViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}