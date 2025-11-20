package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CarModelDto {
    private Long id;
    private String name;
    private Integer yearFrom;
    private Integer yearTo;
}