package com.example.tooo.data

import android.app.Application
import androidx.lifecycle.LiveData
import java.lang.Exception

class UserRepository(application: Application) {
    private val userDataBase = UserDataBase.getInstance(application)!!
    private val userDao: UserDao = userDataBase.userDao()
    private val users: LiveData<List<User>> = userDao.getAll()

    fun getAll(): LiveData<List<User>> {
        return users
    }

    fun insert(user: User) {
        try {
            val thread = Thread(Runnable {
                userDao.insert(user)
            })
            thread.start()
        } catch (e: Exception) { }
    }

    fun delete(user: User) {
        try {
            val thread = Thread( {
                userDao.delete(user)
            })
            thread.start()
        } catch (e: Exception) { }
    }

}