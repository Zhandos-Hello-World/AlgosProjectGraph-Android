package production.zhandos.myapplication.find

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import production.zhandos.myapplication.room.UserDao

class FindViewModel(dao: UserDao): ViewModel() {
    val search = MutableLiveData("")
    val notActive = dao.getNotActivities()
}