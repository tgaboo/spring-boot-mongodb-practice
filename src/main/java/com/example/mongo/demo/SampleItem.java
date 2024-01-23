package com.example.mongo.demo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
@Document("sample-items")
public class SampleItem {

    @MongoId
    private String id;

    private String name;

    private String category;
}
