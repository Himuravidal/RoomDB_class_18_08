package com.crisspian.roomdb_class_18_08.presenter

import androidx.lifecycle.LiveData
import com.crisspian.roomdb_class_18_08.model.Task

interface IView {
    fun showAllTask(list: LiveData<List<Task>>)
    fun showToastMessage(message : String)
}