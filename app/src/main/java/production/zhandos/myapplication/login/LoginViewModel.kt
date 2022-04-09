package production.zhandos.myapplication.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import production.zhandos.myapplication.room.UserDao

class LoginViewModel(private val dao: UserDao, val listener: (Boolean) -> Unit): ViewModel() {
    val username = MutableLiveData("")
    val password = MutableLiveData("")


    fun checkValidate() {
        Log.d("OOPS", "Started")
        viewModelScope.launch {
            if (check(username) && check(password)) {
                val user = dao.getUser(username.value!!, password.value!!)
                if (user != null) {
                    val list = dao.getActivity()
                    for (i in list) {
                        i.active = false
                        dao.update(i)
                    }
                    user.active = true
                    dao.update(user)
                    listener(true)
                }
                else {
                    //Invalid
                }
            }
            else {
                Log.d("OOPS", "it's working now1")
            }
        }
    }

    private fun check(value: MutableLiveData<String>) = !value.value.isNullOrEmpty()

}