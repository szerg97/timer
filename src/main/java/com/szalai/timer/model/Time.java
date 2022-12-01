package com.szalai.timer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "times")
@Setter
@Getter
@NoArgsConstructor
public class Time {

    @Id
    private String id;
    private LocalDateTime timestamp;

    public Time(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
