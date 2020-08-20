package com.crisspian.roomdb_class_18_08.presenter

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.crisspian.roomdb_class_18_08.database.TaskDataBase
import com.crisspian.roomdb_class_18_08.model.Task
import com.crisspian.roomdb_class_18_08.model.TaskRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class TaskPresenter(application: Application, private val iView: IView): IPresenter {
    private val mRepository: TaskRepository
    private val allLiveDataTask : LiveData<List<Task>>

    //private val job = Job()
    private val job = SupervisorJob()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + job)

    init {
        val taskDao = TaskDataBase.getDatabase(application).getTaskDao()
        mRepository = TaskRepository(taskDao)
        allLiveDataTask = mRepository.mAllTasks
    }

    override fun insertTask(task: Task)  {
            inserTest(task)
            iView.showToastMessage("Guardando")
    }

    fun inserTest(task: Task) = coroutineScope.launch {
        mRepository.insertTask(task)
    }


    override fun getAllTasks() {
       iView.showAllTask(allLiveDataTask)
    }



}