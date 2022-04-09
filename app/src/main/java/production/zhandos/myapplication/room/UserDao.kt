package production.zhandos.myapplication.room

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface UserDao {

    @Query("SELECT * FROM user where id = :id")
    suspend fun getById(id: Long): User


    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>


    @Insert
    suspend fun insert(user: User)


}