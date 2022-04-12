package production.zhandos.myapplication.find

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import production.zhandos.myapplication.room.UserDao

class FindViewModelFactory(private val userDao: UserDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FindViewModel::class.java)) {
            return FindViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }

}