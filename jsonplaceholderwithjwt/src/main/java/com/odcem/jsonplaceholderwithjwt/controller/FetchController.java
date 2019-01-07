package com.odcem.jsonplaceholderwithjwt.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.odcem.jsonplaceholderwithjwt.dto.GenericDto;
import com.odcem.jsonplaceholderwithjwt.dto.ItemDto;
import com.odcem.jsonplaceholderwithjwt.dto.LimitDto;

import com.odcem.jsonplaceholderwithjwt.service.FetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/secure")
public class FetchController {

    @Autowired
    FetchService fetchService;

    @PostMapping(value = "/fetch")
    public ResponseEntity<GenericDto<ArrayList<ItemDto>>> fetchFromPlaceHolder(@RequestBody LimitDto limitDto)
            throws IOException, JsonParseException, InterruptedException, ExecutionException {

        GenericDto<ArrayList<ItemDto>> itemResponseDto = fetchService.fetchAndSave(limitDto);
        return new ResponseEntity<>(itemResponseDto, HttpStatus.OK);
    }

}