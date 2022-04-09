package production.zhandos.myapplication.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import production.zhandos.myapplication.room.UserDao
import java.lang.IllegalArgumentException

class RegisterViewModel2Factory(val dao: UserDao, val checked: (value: Boolean) -> Unit): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(Register2ViewModel::class.java)) {
            return Register2ViewModel(dao, checked) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}