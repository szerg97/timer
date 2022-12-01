package com.szalai.timer.repository;

import com.szalai.timer.model.Time;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TimeRepository extends MongoRepository<Time, LocalDateTime> {
}
