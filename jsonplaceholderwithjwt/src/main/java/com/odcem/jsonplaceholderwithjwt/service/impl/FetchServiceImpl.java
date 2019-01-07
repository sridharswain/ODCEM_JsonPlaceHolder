package com.odcem.jsonplaceholderwithjwt.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.odcem.jsonplaceholderwithjwt.dto.GenericDto;
import com.odcem.jsonplaceholderwithjwt.dto.ItemDto;
import com.odcem.jsonplaceholderwithjwt.dto.LimitDto;
import com.odcem.jsonplaceholderwithjwt.entity.ItemEntity;
import com.odcem.jsonplaceholderwithjwt.repo.ItemRepo;
import com.odcem.jsonplaceholderwithjwt.service.FetchService;
import com.odcem.jsonplaceholderwithjwt.validator.LimitValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class FetchServiceImpl implements FetchService {

    @Value("${api.JSON_PLACEHOLDER_ENDPOINT}")
    private String JSON_PLACEHOLDER_ENDPOINT;

    @Autowired
    ItemRepo itemRepo;

    @Override
    public GenericDto<ArrayList<ItemDto>> fetchAndSave(LimitDto limitDto) {
        LimitValidator limitValidator = new LimitValidator(limitDto);
        limitValidator.validate();

        int llimit = limitDto.getLlimit();
        int ulimit = limitDto.getUlimit();

        RestTemplate restTemplate = new RestTemplate();
        ArrayList<ListenableFuture<ResponseEntity<String>>> futureResponses = new ArrayList<>();

        ArrayList<ItemDto> allItems = new ArrayList<>();
        ArrayList<ItemEntity> allEntities = new ArrayList<>();

        Stream<Integer> intStream = IntStream.range(llimit, ulimit + 1).boxed();

        List<CompletableFuture<ItemDto>> results = intStream.map(input -> {
            CompletableFuture<ItemDto> cf = CompletableFuture.supplyAsync(() -> {
                String data = restTemplate.getForEntity(JSON_PLACEHOLDER_ENDPOINT + input, String.class).getBody();
                return data;
            }).thenApply(data -> mapToDto(data, allItems, allEntities));
            return cf;
        }).collect(Collectors.toList());


        CompletableFuture<Void> allFutures = CompletableFuture.allOf(results.toArray(new CompletableFuture[results.size()]));
        allFutures.join();
//
//        CompletableFuture<List<ResponseEntity<String>>> rep = allFutures.thenApply(future -> {
//            return results.stream().map(cmp -> cmp.join()).collect(Collectors.toList());
//        });
//
//        List<ResponseEntity<String>> x = rep.thenApply(x -> {
//            return x.stream().map()
//        })



//        for (int id = llimit; id <= ulimit; id++) {
//            ListenableFuture<ResponseEntity<String>> futureResponse =
//                    restTemplate.getForEntity(JSON_PLACEHOLDER_ENDPOINT + id, String.class);
//            futureResponses.add(futureResponse);
//        }




//        for (ListenableFuture<ResponseEntity<String>> futureResponse : futureResponses) {
//
//        }

        itemRepo.saveAll(allEntities);

        GenericDto<ArrayList<ItemDto>> itemResponseDto = new GenericDto<>(false, allItems);
        return itemResponseDto;
    }

    private ItemDto mapToDto(String data, ArrayList<ItemDto> allItems, ArrayList<ItemEntity> allEntities){
        try {
            ItemDto item = new ObjectMapper().readValue(data,
                    ItemDto.class);
            allItems.add(item);
            allEntities.add(item.toEntity());
            return item;
        } catch (Exception exception) {
            //PASS
            //AS ID NOT FOUND IN DB
        }
        return null;
    }
}
