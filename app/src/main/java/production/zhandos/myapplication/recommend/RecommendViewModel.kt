package production.zhandos.myapplication.recommend

import android.util.Log
import androidx.lifecycle.ViewModel
import production.zhandos.myapplication.room.FollowDao
import production.zhandos.myapplication.room.UserDao

class RecommendViewModel(private val dao: UserDao, private val followDao: FollowDao): ViewModel() {
    val users = dao.getAll()
    val follow = followDao.getAll()
    val current = dao.getActivity()

    fun getAllConnections(): List<FilterUser>? {
        val listFollow = follow.value
        val listUser = users.value
        if (listFollow == null || listUser == null || current.value == null) {
            return null
        }
        fun findById(id: Long): FilterUser {
            for (i in listUser) {
                if (i.id == id) {
                    return FilterUser(i.id, i.login)
                }
            }
            throw Exception("Not found")
        }

        val list = mutableListOf<FilterUser>()
        for (i in listFollow) {
            val first = findById(i.first_id)
            val second = findById(i.second_Id)

            if (!list.containsById(first)) {
                list.add(first)
            }

            if (!list.containsById(second)) {
                list.add(second)
            }
            list.getById(first)!!.friends.add(list.getById(second)!!)
        }
        val currentUser = list.getById(findById(current.value!!.id))

        DFS.set = HashSet()
        DFS.currUser = currentUser
        Log.d("DFS", DFS.bfs(currentUser).joinToString { it.name })
        return DFS.bfs(currentUser)
    }

    private fun MutableList<FilterUser>.containsById(user: FilterUser): Boolean {
        for (i in this) {
            if (user.id == i.id) {
                return true
            }
        }
        return false
    }
    private fun MutableList<FilterUser>.getById(user: FilterUser): FilterUser? {
        for (i in this) {
            if (user.id == i.id) {
                return i
            }
        }
        return null
    }
}