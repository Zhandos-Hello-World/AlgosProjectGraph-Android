package production.zhandos.myapplication.register

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import production.zhandos.myapplication.room.User
import production.zhandos.myapplication.room.UserDao

class Register2ViewModel(private val dao: UserDao, val checked: (value: Boolean) -> Unit) : ViewModel() {
    val usernameV = MutableLiveData("")
    val passwordV = MutableLiveData("")
    val firstNameV = MutableLiveData("")
    val lastNameV = MutableLiveData("")
    val ageV = MutableLiveData("18")

    val users = dao.getAll()

    fun submit() {
        viewModelScope.launch {
            if (check(firstNameV) && check(lastNameV)) {
                for (i in users.value ?: mutableListOf()) {
                    Log.d("USERS", i.firstName)
                }

                val user = User()
                user.apply {
                    login = usernameV.value!!
                    password = passwordV.value!!
                    firstName = firstNameV.value!!
                    lastName = lastNameV.value!!
                    age = ageV.value!!.toInt()
                }
                Log.d("USER", user.toString())

                dao.insert(user)
                Log.d("Dao", "create")
                checked(true)
            }
            else {
                checked(false)
            }
        }

    }

    private fun check(value: MutableLiveData<String>) = !value.value.isNullOrEmpty()

}