package com.example.mongo.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface SampleItemRepository extends MongoRepository<SampleItem, String> {

    @Query("{name: '?0'}")
    SampleItem findByName(String name);

    @Query(value = "{category: '?0'}", fields = "{'name': 1}")
    List<SampleItem> findAllByCategory(String category);

}
