package com.example.demo.service;


import com.example.demo.dto.CarDto;
import java.util.List;

public interface CarService {
    List<CarDto> getAllBrands();
    CarDto getBrandById(Long id);
    CarDto addBrand(CarDto dto);
    CarDto updateBrand(Long id, CarDto dto);
    boolean deleteBrand(Long id);
}