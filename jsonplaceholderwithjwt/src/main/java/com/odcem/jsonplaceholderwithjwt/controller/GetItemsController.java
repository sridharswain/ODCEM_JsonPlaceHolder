package com.odcem.jsonplaceholderwithjwt.controller;

import java.util.ArrayList;

import com.odcem.jsonplaceholderwithjwt.dto.GenericDto;
import com.odcem.jsonplaceholderwithjwt.dto.LimitDto;
import com.odcem.jsonplaceholderwithjwt.repo.ItemRepo;
import com.odcem.jsonplaceholderwithjwt.dto.ItemDto;
import com.odcem.jsonplaceholderwithjwt.entity.ItemEntity;
import com.odcem.jsonplaceholderwithjwt.exception.ParamNotFoundException;

import com.odcem.jsonplaceholderwithjwt.service.impl.GetServiceImpl;
import com.odcem.jsonplaceholderwithjwt.validator.LimitValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/secure")
public class GetItemsController{

    @Autowired
    GetServiceImpl getService;

    @GetMapping("/getItems")
    public ResponseEntity<GenericDto<ArrayList<ItemDto>>> getItemsFromDB(@RequestParam(value = "ulimit", required = false) Integer ulimit,
    @RequestParam(value = "llimit", required = false) Integer llimit){

        LimitDto limitDto = new LimitDto(llimit, ulimit);

        GenericDto<ArrayList<ItemDto>> allItemDtos = getService.getItems(limitDto);

        return new ResponseEntity<>(allItemDtos, HttpStatus.OK);
    }
}