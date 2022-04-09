package production.zhandos.myapplication.room

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey


@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    @ColumnInfo(name = "username")
    var login: String = "",
    @ColumnInfo(name = "password")
    var password: String = "",
    @ColumnInfo(name = "first_name")
    var firstName: String = "",
    @ColumnInfo(name = "last_name")
    var lastName: String = "",
    @ColumnInfo(name = "age")
    var age: Int = 0,
    @ColumnInfo(name = "active")
    var active: Boolean = false
)