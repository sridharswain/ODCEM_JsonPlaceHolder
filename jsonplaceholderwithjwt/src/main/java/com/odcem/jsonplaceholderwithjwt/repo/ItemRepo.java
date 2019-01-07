package com.odcem.jsonplaceholderwithjwt.repo;

import com.odcem.jsonplaceholderwithjwt.entity.ItemEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepo extends JpaRepository<ItemEntity, Long> { 
    // DB functions goes here

    @Query("SELECT i FROM item i where i.id >= :llimit and i.id <= :ulimit")
    public List<ItemEntity> getItemsInRange(@Param("llimit") int llimit, @Param("ulimit") int ulimit);

}