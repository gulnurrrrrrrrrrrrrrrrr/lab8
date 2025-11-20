package com.example.demo.mapper;

import com.example.demo.dto.CarDto;
import com.example.demo.dto.CarModelDto;
import com.example.demo.dto.FeatureDto;
import com.example.demo.entity.Car;
import com.example.demo.entity.CarModel;
import com.example.demo.entity.Feature;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDto toDto(Car car);

    Car toEntity(CarDto dto);

    CarModelDto modelToDto(CarModel model);

    FeatureDto featureToDto(Feature feature);

    @Mapping(target = "car", ignore = true)
    CarModel modelDtoToEntity(CarModelDto dto);

    @Mapping(target = "cars", ignore = true)
    Feature featureDtoToEntity(FeatureDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCarFromDto(CarDto dto, @MappingTarget Car car);
}