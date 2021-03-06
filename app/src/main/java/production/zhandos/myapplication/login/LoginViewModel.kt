package production.zhandos.myapplication.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import production.zhandos.myapplication.room.User
import production.zhandos.myapplication.room.UserDao

class LoginViewModel(private val dao: UserDao, val listener: (Int) -> Unit): ViewModel() {
    val username = MutableLiveData("")
    val password = MutableLiveData("")


    init {
        viewModelScope.launch {
            val list = dao.getActivities()
            if (list.size == 1) {
                val user = list[0]
                if (user != null) {
                    username.value = user.login
                    password.value = user.password
                }
            }

        }
    }


    fun checkValidate() {
        Log.d("OOPS", "Started")
        viewModelScope.launch {
            if (check(username) && check(password)) {
                val user = dao.getUser(username.value!!, password.value!!)
                if (user != null) {
                    val list = dao.getActivities()
                    for (i in list) {
                        i.active = false
                        dao.update(i)
                    }
                    user.active = true
                    dao.update(user)
                    listener(1)
                }
                else {
                    listener(-1)
                }
            }
            else {
                Log.d("OOPS", "it's working now1")
            }
        }
    }

    private fun check(value: MutableLiveData<String>) = !value.value.isNullOrEmpty()

}