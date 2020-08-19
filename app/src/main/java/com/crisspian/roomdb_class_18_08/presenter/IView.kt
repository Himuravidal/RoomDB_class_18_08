package com.crisspian.roomdb_class_18_08.presenter

import com.crisspian.roomdb_class_18_08.model.Task

interface IView {
    fun showAllTask(list: List<Task>)
    fun showToastMessage(message : String)
}