package production.zhandos.myapplication.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface FollowDao {

    @Insert
    suspend fun insert(follow: Follow)

    @Query("SELECT * FROM Follow WHERE second_id = :id")
    fun getFollowers(id: Long): LiveData<List<Follow>>

    @Query("SELECT * FROM Follow WHERE first_id = :id")
    fun getFollowings(id: Long): LiveData<List<Follow>>

    @Query("SELECT COUNT(*) FROM Follow WHERE second_id = :id")
    fun getFollowersCount(id: Long): LiveData<Long>

    @Query("SELECT COUNT(*) FROM Follow WHERE first_id = :id")
    fun getFollowingsCount(id: Long): LiveData<Long>


    @Update
    suspend fun setFollow(follow: Follow)

}