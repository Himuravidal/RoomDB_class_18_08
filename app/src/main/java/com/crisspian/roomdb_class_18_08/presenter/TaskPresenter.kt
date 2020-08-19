package com.crisspian.roomdb_class_18_08.presenter

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.crisspian.roomdb_class_18_08.database.TaskDataBase
import com.crisspian.roomdb_class_18_08.model.Task
import com.crisspian.roomdb_class_18_08.model.TaskRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class TaskPresenter(application: Application, private val iView: IView): IPresenter , CoroutineScope {
    private val mRepository: TaskRepository
    private val allLiveDataTask : LiveData<List<Task>>

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    init {
        val taskDao = TaskDataBase.getDatabase(application).getTaskDao()
        mRepository = TaskRepository(taskDao)
        allLiveDataTask = mRepository.mAllTasks
    }

    override fun insertTask(task: Task) {
            inserTest(task)
            iView.showToastMessage("Guardando")
    }

    fun inserTest(task: Task) = launch {
        mRepository.insertTask(task)
    }


    override fun getAllTasks() {
       iView.showAllTask(allLiveDataTask)
    }



}