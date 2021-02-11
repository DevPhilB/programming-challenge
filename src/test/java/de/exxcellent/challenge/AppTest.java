package de.exxcellent.challenge;

import de.exxcellent.challenge.controller.FootballController;
import de.exxcellent.challenge.controller.WeatherController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * JUnit 5 tests.
 *
 * @author Philipp Backes
 */
class AppTest {

    private CSVReader csvWeatherReader;
    private CSVReader csvFootballReader;
    private WeatherController weatherController;
    private FootballController footballController;

    @BeforeEach
    void setUp() {
        csvWeatherReader = new CSVReader(getClass().getResource("weather.csv").getFile());
        csvFootballReader = new CSVReader(getClass().getResource("football.csv").getFile());
        weatherController = new WeatherController();
        footballController = new FootballController();
    }

    @Test
    void testCSVReaderReadAllLines() {
        assertEquals(30, csvWeatherReader.readAll().size());
    }

    @Test
    void testCSVReaderReadNotAllLines() {
        assertNotEquals(42, csvFootballReader.readAll().size());
    }

    @Test
    void testWeatherControllerParseContent() {
        assertEquals(30, weatherController.parse(csvWeatherReader.readAll()).size());
    }

    @Test
    void testWeatherControllerGetSmallestTemperatureSpreadDay() {
        assertEquals("14", weatherController.getSmallestTemperatureSpreadDay(
                weatherController.parse(csvWeatherReader.readAll())
        ));
    }

    @Test
    void testFootballControllerParseEmptyList() {
        assertEquals(0, footballController.parse(new ArrayList<>()).size());
    }

    @Test
    void testWeatherControllerGetSmallestAbsoluteGoalDifferenceTeamName() {
        assertEquals("Aston_Villa", footballController.getSmallestAbsoluteGoalDifferenceTeamName(
                footballController.parse(csvFootballReader.readAll())
        ));
    }

    @Test
    void testCLIArguments() {
        App.main("--weather", "weather.csv", "--football", "football.csv");
    }

    @Test
    void testApp() {
        App.main();
    }
}
