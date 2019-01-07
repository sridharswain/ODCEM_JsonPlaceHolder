package com.odcem.jsonplaceholderwithjwt.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.odcem.jsonplaceholderwithjwt.dto.GenericDto;
import com.odcem.jsonplaceholderwithjwt.dto.ItemDto;
import com.odcem.jsonplaceholderwithjwt.dto.LimitDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface FetchService {
    public GenericDto<ArrayList<ItemDto>> fetchAndSave(LimitDto limitDto) throws IOException, JsonParseException, InterruptedException, ExecutionException;
}
