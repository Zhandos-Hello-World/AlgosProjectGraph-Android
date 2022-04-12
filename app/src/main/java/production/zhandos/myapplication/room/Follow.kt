package production.zhandos.myapplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Follow")
class Follow(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    @ColumnInfo(name = "follower_id")
    var followerId: Long = 0L,
    @ColumnInfo(name = "following_id")
    var followingId: Long = 0L
)