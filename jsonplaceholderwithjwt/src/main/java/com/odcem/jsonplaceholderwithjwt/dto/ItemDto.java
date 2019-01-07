package com.odcem.jsonplaceholderwithjwt.dto;

import com.odcem.jsonplaceholderwithjwt.entity.ItemEntity;
import com.odcem.jsonplaceholderwithjwt.model.ItemModel;

public class ItemDto extends ItemModel {
    public ItemDto(int userId, int id, String title, boolean completed){
        super(userId, id, title, completed);
    }

    public ItemDto() { super(); }

    public ItemEntity toEntity(){
        return new ItemEntity(getUserId(), getId(), getTitle(), getCompleted());
    }
}