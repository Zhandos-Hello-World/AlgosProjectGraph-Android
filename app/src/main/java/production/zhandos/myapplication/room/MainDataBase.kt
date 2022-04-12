package production.zhandos.myapplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class, Follow::class], version = 1, exportSchema = true)
abstract class MainDataBase: RoomDatabase(){
    abstract val dao: UserDao
    abstract val followDao: FollowDao

    companion object {
        @Volatile
        private var INSTANCE: MainDataBase? = null

        fun getINSTANCE(context: Context): MainDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context,
                                MainDataBase::class.java,
                                "UserDB").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}