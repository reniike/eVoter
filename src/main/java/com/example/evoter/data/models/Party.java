package com.example.evoter.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Parties")
@AllArgsConstructor
@NoArgsConstructor
public class Party {
    @Id
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String candidate;
}
