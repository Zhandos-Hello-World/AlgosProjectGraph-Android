package production.zhandos.myapplication.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM user where id = :id")
    suspend fun getById(id: Long): User


    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    suspend fun getUser(username: String, password: String): User?

    @Query("SELECT * FROM user WHERE active = 1")
    fun getActivity(): LiveData<User>

    @Query("SELECT * FROM user WHERE active = 1")
    suspend fun getActivities(): List<User>

    @Query("SELECT * FROM user WHERE active = 0")
    fun getNotActivities(): LiveData<List<User>>

    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>

//    @Query("SELECT * FROM user INNER JOIN Follow ON follower_id=id INNER JOIN user ON id=:id")
//    fun getFriends(id: Long): LiveData<List<User>>

    @Update
    suspend fun update(user: User)


    @Insert
    suspend fun insert(user: User)

}