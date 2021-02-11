package de.exxcellent.challenge.controller;

import de.exxcellent.challenge.model.Football;

import java.util.ArrayList;

/**
 * The football controller handles the parsing to football models and returns specific football data.
 *
 * @author Philipp Backes
 */
public class FootballController implements Parser<Football> {

    @Override
    public ArrayList<Football> parse(ArrayList<String[]> content) {
        ArrayList<Football> models = new ArrayList<>();
        content.forEach((row) -> models.add(new Football(row[0], Integer.parseInt(row[5]), Integer.parseInt(row[6]))));
        return models;
    }

    /**
     * Returns the team name with the smallest absolute goal difference.
     *
     * @param models An ArrayList of football models.
     * @return Empty string or a team name.
     */
    public String getSmallestAbsoluteGoalDifferenceTeamName(ArrayList<Football> models) {
        String teamName = "";
        int lastDifference = Integer.MAX_VALUE;
        for (Football model : models) {
            int difference = Math.abs(model.getGoals() - model.getGoalsAllowed());
            if (difference < lastDifference) {
                teamName = model.getTeamName();
                lastDifference = difference;
            }
        }
        return teamName;
    }
}
