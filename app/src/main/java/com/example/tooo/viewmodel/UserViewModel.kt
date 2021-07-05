package com.example.tooo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.tooo.data.User
import com.example.tooo.data.UserRepository

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = UserRepository(application)
    private val users = repository.getAll()

    fun getAll(): LiveData<List<User>> {
        return this.users
    }

    fun insert(user: User) {
        repository.insert(user)
    }

    fun delete(user: User) {
        repository.insert(user)
    }

}