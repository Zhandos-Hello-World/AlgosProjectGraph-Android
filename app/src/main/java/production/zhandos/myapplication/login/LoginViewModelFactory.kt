package production.zhandos.myapplication.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import production.zhandos.myapplication.room.UserDao

class LoginViewModelFactory(private val dao: UserDao, private val listener: (Int) -> Unit) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(dao, listener) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}