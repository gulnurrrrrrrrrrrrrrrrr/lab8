package com.example.demo.service.impl;


import com.example.demo.dto.CarDto;
import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository brandRepository;

    @Override
    public List<CarDto> getAllBrands() {
        List<Car> brands = brandRepository.findAll();
        List<CarDto> dtoList = new ArrayList<>();
        brands.forEach(brand -> dtoList.add(toDto(brand)));
        return dtoList;
    }

    @Override
    public CarDto getBrandById(Long id) {
        Car brand = brandRepository.findById(id).orElse(null);
        if (Objects.isNull(brand)) return null;
        return toDto(brand);
    }

    @Override
    public CarDto addBrand(CarDto dto) {
        Car brand = toEntity(dto);
        Car created = brandRepository.save(brand);
        return toDto(created);
    }

    @Override
    public CarDto updateBrand(Long id, CarDto dto) {
        CarDto check = getBrandById(id);
        if (Objects.isNull(check)) return null;

        Car brand = toEntity(dto);
        brand.setId(id);
        Car updated = brandRepository.save(brand);
        return toDto(updated);
    }

    @Override
    public boolean deleteBrand(Long id) {
        CarDto check = getBrandById(id);
        if (Objects.isNull(check)) return false;
        brandRepository.deleteById(id);
        return true;
    }

    private CarDto toDto(Car brand) {
        return CarDto.builder()
                .id(brand.getId())
                .brandName(brand.getName())
                .country(brand.getCountry())
                .foundedYear(brand.getFoundedYear())
                .isLuxury(brand.isLuxury())
                .build();
    }

    private Car toEntity(CarDto dto) {
        Car brand = new Car();
        brand.setId(dto.getId());
        brand.setName(dto.getBrandName());
        brand.setCountry(dto.getCountry());
        brand.setFoundedYear(dto.getFoundedYear());
        brand.setLuxury(dto.isLuxury());
        return brand;
    }
}