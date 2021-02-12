package de.exxcellent.challenge.controller;

import de.exxcellent.challenge.model.Weather;

import java.util.ArrayList;
import java.util.List;

/**
 * The weather controller handles the parsing to weather models and returns specific weather data.
 *
 * @author Philipp Backes
 */
public class WeatherController implements Parser<Weather> {

    @Override
    public ArrayList<Weather> parse(List<String[]> content) {
        ArrayList<Weather> models = new ArrayList<>();
        content.forEach((row) -> models.add(new Weather(row[0], Integer.parseInt(row[1]), Integer.parseInt(row[2]))));
        return models;
    }

    /**
     * Returns the day with the smallest temperate spread.
     *
     * @param models An ArrayList of weather models.
     * @return Empty string or a day.
     */
    public String getSmallestTemperatureSpreadDay(ArrayList<Weather> models) {
        String day = "";
        int lastDifference = Integer.MAX_VALUE;
        for (Weather model : models) {
            int difference = model.getMaximumTemperature() - model.getMinimumTemperature();
            if (difference < lastDifference) {
                day = model.getDay();
                lastDifference = difference;
            }
        }
        return day;
    }
}
