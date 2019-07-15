package com.dawanse.ieltsforall.db;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "task")
public class Task {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "taskname")
    private String taskName;
    @ColumnInfo(name = "header")
    private String header;
    @ColumnInfo(name = "pretitle")
    private String preTitle;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "passage")
    private String passage;

    @Ignore
    public Task () {}

    public Task(String taskName, String header, String preTitle, String title, String passage) {
        this.taskName = taskName;
        this.header = header;
        this.preTitle = preTitle;
        this.title = title;
        this.passage = passage;
    }

    @Ignore
    public Task(String header, String preTitle, String title, String passage) {
        this.header = header;
        this.preTitle = preTitle;
        this.title = title;
        this.passage = passage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPreTitle() {
        return preTitle;
    }

    public void setPreTitle(String preTitle) {
        this.preTitle = preTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassage() {
        return passage;
    }

    public void setPassage(String passage) {
        this.passage = passage;
    }
}
