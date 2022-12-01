package com.szalai.timer.controller;

import com.szalai.timer.model.Time;
import com.szalai.timer.repository.TimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/timer")
@AllArgsConstructor
public class TimeController {

    private final TimeRepository repository;

    @GetMapping(path = "")
    public List<Time> getTime(){
        LocalDateTime now = LocalDateTime.now();
        repository.save(new Time(now));
        return repository.findAll();
    }
}
