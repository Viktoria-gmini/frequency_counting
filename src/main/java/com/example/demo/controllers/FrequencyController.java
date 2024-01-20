package com.example.demo.controllers;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
@Api(value = "FrequencyController")
public class FrequencyController {

    @PostMapping("/frequency")
    public ResponseEntity<Map<Character, Integer>> calculateFrequency(String inputString) {
        if (inputString.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be empty");
        } else if (inputString.length() > 100) {
            throw new IllegalArgumentException("Input string cannot be longer than 100 chars");
        }
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : inputString.toCharArray()) {
            if (frequencyMap.containsKey(c)) {
                frequencyMap.put(c, frequencyMap.get(c) + 1);
            } else {
                frequencyMap.put(c, 1);
            }
        }
        Map<Character, Integer> sortedFrequencyMap = frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return ResponseEntity.ok(sortedFrequencyMap);
    }
}
