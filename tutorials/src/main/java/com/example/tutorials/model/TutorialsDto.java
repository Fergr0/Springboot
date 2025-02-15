package com.example.tutorials.model;

import lombok.*;

@Getter
@Setter

@Builder
public class TutorialsDto {
    private String id;
    private String title;
    private String description;
    private Boolean published;
}
