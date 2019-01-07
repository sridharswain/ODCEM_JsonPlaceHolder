package com.odcem.jsonplaceholderwithjwt.service.impl;

import com.odcem.jsonplaceholderwithjwt.dto.GenericDto;
import com.odcem.jsonplaceholderwithjwt.dto.ItemDto;
import com.odcem.jsonplaceholderwithjwt.dto.LimitDto;
import com.odcem.jsonplaceholderwithjwt.entity.ItemEntity;
import com.odcem.jsonplaceholderwithjwt.repo.ItemRepo;
import com.odcem.jsonplaceholderwithjwt.service.GetService;
import com.odcem.jsonplaceholderwithjwt.validator.LimitValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetServiceImpl implements GetService {

    @Autowired
    ItemRepo itemRepo;

    @Override
    public GenericDto<ArrayList<ItemDto>> getItems(LimitDto limitDto) {
        LimitValidator limitValidator = new LimitValidator(limitDto);
        limitValidator.validate();

        ArrayList<ItemDto> allItemDtos = new ArrayList<>();

        int ulimit = limitDto.getUlimit();
        int llimit = limitDto.getLlimit();

        List<ItemEntity> allItemEntities = itemRepo.getItemsInRange(llimit, ulimit);

        for(ItemEntity itemEntity : allItemEntities){
            allItemDtos.add(itemEntity.toItemDto());
        }

        return new GenericDto<>(false, allItemDtos);
    }
}
