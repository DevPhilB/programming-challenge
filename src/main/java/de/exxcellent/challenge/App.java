package de.exxcellent.challenge;

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
        // Weather task
        CSVReader csvReader = new CSVReader();
        final String weatherFile = "weather.csv"; // Could be replaced with a CLI argument
        String dayWithSmallestTempSpread = csvReader.getSmallestTemperatureSpreadDay(weatherFile);
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        // Football task
        final String footballFile = "football.csv"; // Could be replaced with a CLI argument
        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
