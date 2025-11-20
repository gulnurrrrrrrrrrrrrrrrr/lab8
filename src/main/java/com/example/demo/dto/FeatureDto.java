package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FeatureDto {
    private Long id;
    private String name;
}