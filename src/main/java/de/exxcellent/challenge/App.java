package de.exxcellent.challenge;

import de.exxcellent.challenge.controller.FootballController;
import de.exxcellent.challenge.controller.WeatherController;

/**
 * The entry class for your solution.
 * This class is only aimed as starting point and not intended as baseline for your software design.
 * Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed.
     */
    public static void main(String... args) {
        String weatherFilePath = "";
        String footballFilePath = "";
        // Check for CLI arguments: --weather and/or --football
        try {
            if(args.length >= 2 && args[0].equals("--weather")) {
                weatherFilePath = App.class.getResource(args[1]).getFile();
            } else if(args.length >= 2 && args[0].equals("--football")) {
                footballFilePath = App.class.getResource(args[1]).getFile();
            }
            if(args.length >= 4 && args[2].equals("--weather")) {
                weatherFilePath = App.class.getResource(args[3]).getFile();
            } else if(args.length >= 4 && args[2].equals("--football")) {
                footballFilePath = App.class.getResource(args[3]).getFile();
            }
        } catch(NullPointerException e) {
            // In case of invalid arguments, reset both strings.
            weatherFilePath = "";
            footballFilePath = "";
            e.getStackTrace();
        }

        // Execute weather task
        if(weatherFilePath.equals("")) {
            weatherFilePath = App.class.getResource("weather.csv").getFile();
        }
        CSVReader csvWeatherReader = new CSVReader(weatherFilePath);
        WeatherController weatherController = new WeatherController();
        String day = weatherController.getSmallestTemperatureSpreadDay(
                weatherController.parse(csvWeatherReader.readAll())
        );
        System.out.printf("Day with smallest temperature spread : %s%n", day);

        // Execute football task
        if(footballFilePath.equals("")) {
            footballFilePath = App.class.getResource("football.csv").getFile();
        }
        CSVReader csFootballReader = new CSVReader(footballFilePath);
        FootballController footballController = new FootballController();
        String teamName = footballController.getSmallestAbsoluteGoalDifferenceTeamName(
                footballController.parse(csFootballReader.readAll())
        );
        System.out.printf("Team with smallest goal spread       : %s%n", teamName);
    }
}
