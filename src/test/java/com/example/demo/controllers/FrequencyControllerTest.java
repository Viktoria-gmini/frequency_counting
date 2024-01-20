package com.example.demo.controllers;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class FrequencyControllerTest {

    private final FrequencyController frequencyController = new FrequencyController();

    @Test
    public void testCalculateFrequency() {
        String inputString = "aaaaabcccc";
        Map<Character, Integer> expected = Map.of('a', 5, 'c', 4, 'b', 1);
        ResponseEntity<Map<Character, Integer>> response = frequencyController.calculateFrequency(inputString);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testInputStringNotEmpty() {
        assertThatThrownBy(() -> frequencyController.calculateFrequency(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input string cannot be empty");
    }
    @Test
    void testInputStringMaxLength() {
        String longString = "very_long_string_very_long_string_very_long_string_very_long_string_very_long_string_very_long_string...";
        assertThatThrownBy(() -> frequencyController.calculateFrequency(longString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input string cannot be longer than 100 chars");
    }
}


