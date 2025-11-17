package com.example.demo.controller;

import com.example.demo.dto.CarDto;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class MainController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<?> getAllBrands() {
        List<CarDto> dtoList = carService.getAllBrands();
        if (dtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.ok(dtoList);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBrand(@PathVariable Long id) {
        CarDto dto = carService.getBrandById(id);
        if (Objects.isNull(dto)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(dto);
        }
    }

    @PostMapping
    public ResponseEntity<?> addBrand(@RequestBody CarDto dto) {
        CarDto createdDto = carService.addBrand(dto);
        return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBrand(@PathVariable Long id, @RequestBody CarDto dto) {
        CarDto updatedDto = carService.updateBrand(id, dto);
        if (Objects.isNull(updatedDto)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(updatedDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id) {
        boolean deleted = carService.deleteBrand(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}