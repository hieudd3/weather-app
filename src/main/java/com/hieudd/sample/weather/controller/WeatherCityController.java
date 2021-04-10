package com.hieudd.sample.weather.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherCityController extends AbstractController {

    @PostMapping("city/save")
    public ResponseEntity save() {
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "city/get", method = RequestMethod.GET)
    public ResponseEntity get() {
        return ResponseEntity.ok("hello");
    }
}
