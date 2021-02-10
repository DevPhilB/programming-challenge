package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    private String successLabel = "not successful";
    private CSVReader csvReader;

    @BeforeEach
    void setUp() {
        successLabel = "successful";
        csvReader = new CSVReader();
    }

    @Test
    void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    void testCSVReaderWithExistingFile() {
        assertEquals("14", csvReader.getSmallestTemperatureSpreadDay("weather.csv"));
    }

    @Test
    void testCSVReaderWithNonExistingFile() {
        assertEquals("", csvReader.getSmallestTemperatureSpreadDay("weathers.csv"));
    }

    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }

}