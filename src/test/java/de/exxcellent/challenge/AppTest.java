package de.exxcellent.challenge;

import de.exxcellent.challenge.controller.FootballController;
import de.exxcellent.challenge.controller.WeatherController;
import de.exxcellent.challenge.model.Football;
import de.exxcellent.challenge.model.Weather;
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
        String weatherFilePath = "src/main/resources/de/exxcellent/challenge/weather.csv";
        csvWeatherReader = new CSVReader(weatherFilePath);
        String footballFilePath = "src/main/resources/de/exxcellent/challenge/football.csv";
        csvFootballReader = new CSVReader(footballFilePath);
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
        assertEquals("Aston_Villa",
                footballController.getSmallestAbsoluteGoalDifferenceTeamName(
                    footballController.parse(csvFootballReader.readAll())
                )
        );
    }

    @Test
    void testWeatherModelClass() {
        String day = "1";
        int maximumTemperature = 42;
        int minimumTemperature = 17;
        Weather weather = new Weather(day, maximumTemperature, minimumTemperature);
        assertEquals(day, weather.getDay());
        assertEquals(maximumTemperature, weather.getMaximumTemperature());
        assertEquals(minimumTemperature, weather.getMinimumTemperature());
    }

    @Test
    void testFootballModelClass() {
        String teamName = "SSV Ulm";
        int goals = 2;
        int goalsAllowed = 42;
        Football football = new Football(teamName, goals, goalsAllowed);
        assertEquals(teamName, football.getTeamName());
        assertEquals(goals, football.getGoals());
        assertEquals(goalsAllowed, football.getGoalsAllowed());
    }

    @Test
    void testAppWithCLIArguments() {
        App.main("--weather", "src/main/resources/de/exxcellent/challenge/weather.csv",
                "--football", "src/main/resources/de/exxcellent/challenge/football.csv"
        );
    }

    @Test
    void testAppWithoutCLIArguments() {
        App.main();
    }
}
