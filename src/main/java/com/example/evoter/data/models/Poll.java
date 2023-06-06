package com.example.evoter.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Poll")
@AllArgsConstructor
@NoArgsConstructor
public class Poll {
    @Id
    private String voterId;
    @NonNull
    private String partyName;
}
