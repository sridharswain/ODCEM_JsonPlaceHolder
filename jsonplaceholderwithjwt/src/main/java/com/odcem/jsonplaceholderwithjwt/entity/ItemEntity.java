package com.odcem.jsonplaceholderwithjwt.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.odcem.jsonplaceholderwithjwt.dto.ItemDto;
import com.odcem.jsonplaceholderwithjwt.model.ItemModel;

@Entity(name = "item")
@Table(name = "item")
public class ItemEntity extends ItemModel {

    public ItemEntity(int userid, int id, String title, boolean completed){
        super(userid, id, title, completed);
    }

    public ItemEntity() { }

    public ItemDto toItemDto(){
        return new ItemDto(getUserId(), getId(), getTitle(), getCompleted());
    }
}