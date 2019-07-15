package com.dawanse.ieltsforall.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("Select * from task")
    List<Task> getTaskList();

    @Insert()
    void insertTask(Task task);

    @Update()
    void updateTask(Task task);

    @Delete()
    void deleteTask(Task task);

    @Query("SELECT * FROM task WHERE id = :id")
    Task loadTaskByID(int id);
}
