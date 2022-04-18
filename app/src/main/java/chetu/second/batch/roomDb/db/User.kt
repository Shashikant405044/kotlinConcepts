package chetu.second.batch.roomDb.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int,

    @ColumnInfo(name = "fName")
    var firstName : String,

    @ColumnInfo(name = "lName")
    var lastName : String,

    @ColumnInfo(name = "phone")
    var mobileNo : String
)