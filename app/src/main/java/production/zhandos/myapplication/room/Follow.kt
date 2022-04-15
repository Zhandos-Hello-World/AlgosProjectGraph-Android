package production.zhandos.myapplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Follow")
class Follow(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    @ColumnInfo(name = "first_id")
    var first_id: Long = 0L,
    @ColumnInfo(name = "second_id")
    var second_Id: Long = 0L
)