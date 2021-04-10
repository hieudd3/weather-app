package com.hieudd.sample.weather.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherHistoryController extends AbstractController{
    @DeleteMapping("history/delete")
    public ResponseEntity delete(){
        return ResponseEntity.noContent().build();
    }

    @PutMapping("history/update")
    public ResponseEntity update(){
        return ResponseEntity.noContent().build();
    }

    @GetMapping("history/get")
    public ResponseEntity get(){
        return ResponseEntity.noContent().build();
    }
}
