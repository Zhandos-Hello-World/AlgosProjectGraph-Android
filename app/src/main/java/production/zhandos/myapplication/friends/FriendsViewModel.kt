package production.zhandos.myapplication.friends

import androidx.lifecycle.ViewModel
import production.zhandos.myapplication.room.UserDao

class FriendsViewModel(dao: UserDao): ViewModel() {
    val user = dao.getActivity()
//    val getFriends = dao.getFriends(user.value!!.id)
}