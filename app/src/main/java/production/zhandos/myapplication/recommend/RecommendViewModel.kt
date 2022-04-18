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


        val map = mutableMapOf<Long, List<FilterUser>>()

        for (i in listFollow) {
            val friends = map[i.first_id]
            map[i.first_id] =  if (friends == null) {
                listOf(findById(i.second_Id))
            } else {
                val temp = friends.toMutableList()
                temp.add(findById(i.second_Id))
                temp
            }
        }
        var currentUser = findById(current.value!!.id)

        var temp = HashMap<FilterUser, ArrayList<FilterUser>>()
        for (i in map) {

            temp[findById(i.key)] = ArrayList(i.value)
        }
        DFS.hm = temp

        return DFS.bfs(currentUser)
    }

}