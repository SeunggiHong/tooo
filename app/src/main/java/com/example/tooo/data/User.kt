package com.example.tooo.data

import android.util.Log
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,
    @ColumnInfo(name = "photo")
    var userPhoto: String,
    @ColumnInfo(name = "name")
    var userName: String,
    @ColumnInfo(name = "email")
    var userEmail: String,
    @ColumnInfo(name = "phone")
    var userPhone: String
)