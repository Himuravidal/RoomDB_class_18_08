package com.crisspian.roomdb_class_18_08.presenter

import android.app.Application
import com.crisspian.roomdb_class_18_08.database.TaskDataBase
import com.crisspian.roomdb_class_18_08.model.Task
import com.crisspian.roomdb_class_18_08.model.TaskRepository

class TaskPresenter(application: Application, private val iView: IView): IPresenter {
    private val mRepository: TaskRepository
    private val allTaskData : List<Task>

    init {
        val taskDao = TaskDataBase.getDatabase(application).getTaskDao()
        mRepository = TaskRepository(taskDao)
        allTaskData = mRepository.mAllTasks
    }

    override fun insertTask(task: Task) {
        mRepository.insertTask(task)
        iView.showToastMessage("Guardando")
    }

    override fun getAllTasks() {
       iView.showAllTask(allTaskData)
    }

}