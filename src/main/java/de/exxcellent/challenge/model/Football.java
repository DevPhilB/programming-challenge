package de.exxcellent.challenge.model;

/**
 * The model for the important results of the English Premier League.
 *
 * @author Philipp Backes
 */
public class Football {
    private String teamName;
    private int goals;
    private int goalsAllowed;

    /**
     * Constructor for a football model.
     *
     * @param teamName The name of the football team.
     * @param goals The goals scored by the football team.
     * @param goalsAllowed The goals against the football team.
     */
    public Football(String teamName, int goals, int goalsAllowed) {
        this.teamName = teamName;
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
    }

    /**
     * Getter for the name of the football team.
     *
     * @return Name of the football team.
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Getter for the scored goals.
     *
     * @return Number of scored goals.
     */
    public int getGoals() {
        return goals;
    }

    /**
     * Getter for the goals against the football team.
     *
     * @return Number of goals against the football team.
     */
    public int getGoalsAllowed() {
        return goalsAllowed;
    }
}
