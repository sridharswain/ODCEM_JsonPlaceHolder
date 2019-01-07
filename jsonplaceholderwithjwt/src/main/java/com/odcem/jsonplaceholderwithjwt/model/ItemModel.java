package com.odcem.jsonplaceholderwithjwt.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ItemModel {

    @Column(name = "userId")
    private Integer userId;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "completed")
    private Boolean completed;

    public ItemModel(int userId, int id, String title, boolean completed){
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public ItemModel() { }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public void setId(int id){
        this.id = id; 
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    public int getUserId(){
        return this.userId;
    }

    public int getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public boolean getCompleted(){
        return this.completed;
    }
}