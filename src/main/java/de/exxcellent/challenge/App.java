package de.exxcellent.challenge;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import de.exxcellent.challenge.controller.FootballController;
import de.exxcellent.challenge.controller.WeatherController;

import java.util.Optional;

/**
 * The entry class for your solution.
 * This class is only aimed as starting point and not intended as baseline for your software design.
 * Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    @Parameter(names={"--weather"})
    private String weatherFilePath;

    @Parameter(names={"--football"})
    private String footballFilePath;

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed.
     */
    public static void main(String... args) {
        App app = new App();
        // Check for CLI arguments: --weather and/or --football.
        JCommander.newBuilder()
                .addObject(app)
                .build()
                .parse(args);
        // In case of missing or empty file name(s), try these fallbacks.
        if (Optional.ofNullable(app.weatherFilePath).isEmpty()) {
            app.weatherFilePath = "src/main/resources/de/exxcellent/challenge/weather.csv";
        }
        if (Optional.ofNullable(app.footballFilePath).isEmpty()) {
            app.footballFilePath = "src/main/resources/de/exxcellent/challenge/football.csv";
        }

        // Execute weather task (1).
        CSVReader csvWeatherReader = new CSVReader(app.weatherFilePath);
        WeatherController weatherController = new WeatherController();
        String day = weatherController.getSmallestTemperatureSpreadDay(
                weatherController.parse(csvWeatherReader.readAll())
        );
        System.out.printf("Day with smallest temperature spread : %s%n", day);

        // Execute football task (2).
        CSVReader csFootballReader = new CSVReader(app.footballFilePath);
        FootballController footballController = new FootballController();
        String teamName = footballController.getSmallestAbsoluteGoalDifferenceTeamName(
                footballController.parse(csFootballReader.readAll())
        );
        System.out.printf("Team with smallest goal spread       : %s%n", teamName);
    }
}
