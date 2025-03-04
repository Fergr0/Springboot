package com.example.tutorials.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "tutorials")
public class TutorialsVO {
    @Id
    private String id;
    private String title;
    private String description;
    private Boolean published;
}
