package com.example.evoter.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Poll")
public class Poll {
    @Id
    private String voterId;
    private String partyName;
}
