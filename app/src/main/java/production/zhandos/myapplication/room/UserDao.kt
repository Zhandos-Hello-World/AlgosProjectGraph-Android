package production.zhandos.myapplication.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM user where id = :id")
    fun getById(id: Long): LiveData<User>


    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    suspend fun getUser(username: String, password: String): User?

    @Query("SELECT * FROM user WHERE active = 1 LIMIT 1")
    fun getActivity(): LiveData<User>

    @Query("SELECT * FROM user WHERE active = 1")
    suspend fun getActivities(): List<User>

    @Query("SELECT * FROM user WHERE id NOT IN (SELECT second_id FROM Follow F INNER JOIN User U ON F.first_id = U.id AND U.active = 1) AND active == 0;")
    fun getNotFollowings(): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE id IN (SELECT second_id FROM Follow F INNER JOIN User U ON F.first_id = U.id AND U.active = 1) AND active == 0;")
    fun getFollowings(): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE id IN (SELECT first_id FROM Follow F INNER JOIN User U ON F.second_id = U.id AND U.active = 1) AND active == 0;")
    fun getFollowers(): LiveData<List<User>>

    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>


    @Update
    suspend fun update(user: User)


    @Insert
    suspend fun insert(user: User)

}