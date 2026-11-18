package com.example.tourist.controller;

import com.example.tourist.model.Tourist;
import com.example.tourist.repository.TouristRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {
    private final TouristRepository touristRepository;

    public TouristController(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    @GetMapping
    public ResponseEntity<List<Tourist>> getAllTourists() {
        return ResponseEntity.ok(touristRepository.findAll());
    }
}
