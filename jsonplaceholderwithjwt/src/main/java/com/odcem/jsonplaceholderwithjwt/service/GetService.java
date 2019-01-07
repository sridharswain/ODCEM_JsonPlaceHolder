package com.odcem.jsonplaceholderwithjwt.service;

import com.odcem.jsonplaceholderwithjwt.dto.GenericDto;
import com.odcem.jsonplaceholderwithjwt.dto.ItemDto;
import com.odcem.jsonplaceholderwithjwt.dto.LimitDto;

import java.util.ArrayList;

public interface GetService {
    public GenericDto<ArrayList<ItemDto>> getItems(LimitDto limitDto);
}
