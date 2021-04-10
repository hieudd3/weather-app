package com.oddle.app.weather.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class WeatherController extends AbstractController{
    @GetMapping("health-check")
    public final ResponseEntity healthCheck() {
        return ResponseEntity.noContent().build();
    }
}