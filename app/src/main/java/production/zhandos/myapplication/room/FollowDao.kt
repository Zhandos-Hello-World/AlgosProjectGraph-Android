package production.zhandos.myapplication.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface FollowDao {

    @Insert
    suspend fun insert(follow: Follow)

    @Query("SELECT * FROM Follow WHERE following_id = :id")
    fun getFollowers(id: Long): LiveData<List<Follow>>

    @Query("SELECT * FROM Follow WHERE follower_id = :id")
    fun getFollowings(id: Long): LiveData<List<Follow>>

    @Query("SELECT COUNT(*) FROM Follow WHERE following_id = :id")
    fun getFollowersCount(id: Long): LiveData<Long>

    @Query("SELECT COUNT(*) FROM Follow WHERE follower_id = :id")
    fun getFollowingsCount(id: Long): LiveData<Long>


    @Update
    suspend fun setFollow(follow: Follow)

}