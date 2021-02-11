package de.exxcellent.challenge.model;

/**
 * The model for the important daily weather data of a single month.
 *
 * @author Philipp Backes
 */
public class Weather {
    private String day;
    private int maximumTemperature;
    private int minimumTemperature;

    /**
     * Constructor for a weather model.
     *
     * @param day The day.
     * @param maximumTemperature Min temperature.
     * @param minimumTemperature Max temperature.
     */
    public Weather(String day, int maximumTemperature, int minimumTemperature) {
        this.day = day;
        this.maximumTemperature = maximumTemperature;
        this.minimumTemperature = minimumTemperature;
    }

    /**
     * Getter for the day.
     *
     * @return Day as string.
     */
    public String getDay() {
        return day;
    }

    /**
     * Getter for the maximum temperature.
     *
     * @return Max temperature as int.
     */
    public int getMaximumTemperature() {
        return maximumTemperature;
    }

    /**
     * Getter for the minimum temperature.
     *
     * @return Min temperature as int.
     */
    public int getMinimumTemperature() {
        return minimumTemperature;
    }
}
