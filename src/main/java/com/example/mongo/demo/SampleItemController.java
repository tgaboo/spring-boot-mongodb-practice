package com.example.mongo.demo;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("sample")
@RequiredArgsConstructor
public class SampleItemController {

    private final SampleItemRepository repository;

    @GetMapping
    public ResponseEntity<SampleItem> getByName(String name) {
        return ResponseEntity.ok(repository.findByName(name));
    }

    @GetMapping("all")
    public ResponseEntity<List<SampleItem>> getByCategory(String category) {
        return ResponseEntity.ok(repository.findAllByCategory(category));
    }

    @PostMapping
    public ResponseEntity<SampleItem> create(@RequestBody SampleItem sampleItem) {
        return ResponseEntity.status(CREATED)
                .body(repository.insert(sampleItem));
    }
}
