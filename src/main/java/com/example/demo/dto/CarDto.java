package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CarDto {
    private Long id;
    private String brandName;
    private String country;
    private Integer foundedYear;
    private boolean isLuxury;

    private List<CarModelDto> models;
    private List<FeatureDto> features;
}