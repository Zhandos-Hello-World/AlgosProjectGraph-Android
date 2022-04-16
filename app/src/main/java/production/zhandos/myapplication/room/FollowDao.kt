package production.zhandos.myapplication.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FollowDao {

    @Insert
    suspend fun insert(follow: Follow)

    @Query("DELETE FROM follow WHERE first_id = :firstId AND second_id = :secondId")
    suspend fun deleteCustom(firstId: Long, secondId: Long)


    @Query("SELECT COUNT(DISTINCT first_id) FROM Follow WHERE second_id = (SELECT id FROM user WHERE active=1)")
    fun getFollowersCount(): LiveData<Long>

    @Query("SELECT COUNT(DISTINCT second_id) FROM Follow WHERE first_id = (SELECT id FROM user WHERE active=1)")
    fun getFollowingsCount(): LiveData<Long>

    @Update
    suspend fun setFollow(follow: Follow)

}