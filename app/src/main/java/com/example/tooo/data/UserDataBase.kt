package com.example.tooo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDataBase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var instance: UserDataBase? = null

        fun getInstance(context: Context): UserDataBase? {
            if (instance == null) {
                synchronized(UserDataBase::class){
                    instance = Room.databaseBuilder(context.applicationContext,
                        UserDataBase::class.java, "user")
                        .fallbackToDestructiveMigration()
                        .build()
                }

            }
            return instance
        }

    }
}