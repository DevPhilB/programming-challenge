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
    void runFootball() {
        App.main("--football", "football.csv");
    }

    // Own unit tests
    @Test
    void testCSVReaderWithNonExistingFile() {
        assertEquals("", csvReader.findValue("weathers.csv", 0, 1, 2));
    }

    @Test
    void testFirstTask() {
        assertEquals("14", csvReader.findValue("weather.csv", 0, 1, 2));
    }

    @Test
    void testSecondTask() {
        assertEquals("Aston_Villa", csvReader.findValue("football.csv",0, 5,6));
    }
}