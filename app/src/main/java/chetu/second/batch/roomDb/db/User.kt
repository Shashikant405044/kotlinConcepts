package chetu.second.batch.roomDb.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int,

    @ColumnInfo(name = "fName")
    val firstName : String,

    @ColumnInfo(name = "lName")
    val lastName : String,

    @ColumnInfo(name = "phone")
    val mobileNo : String
)