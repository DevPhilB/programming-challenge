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
        final String weatherFile = "weather.csv"; // Option to assign a CLI argument
        String dayWithSmallestTempSpread = csvReader.findValue(weatherFile, 0, 1, 2);
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        // Football task
        final String footballFile = "football.csv"; // Option to assign a CLI argument
        String teamWithSmallestGoalSpread = csvReader.findValue(footballFile,0, 5, 6);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
