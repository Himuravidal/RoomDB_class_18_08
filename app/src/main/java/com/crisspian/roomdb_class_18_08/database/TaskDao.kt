package com.crisspian.roomdb_class_18_08.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.crisspian.roomdb_class_18_08.model.Task

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Insert
    fun insertMultipleTask(list: List<Task>)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteOneTask(task: Task)

    @Query("SELECT * FROM task_table ORDER BY idTask ASC")
    fun getAllTask(): LiveData<List<Task>>


}