package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarDto {
    private Long id;
    private String brandName;
    private String country;
    private Integer foundedYear;
    private boolean isLuxury;
}