package de.exxcellent.challenge;

import java.util.ArrayList;

/**
 * An interface to read single files at once.
 *
 * @author Philipp Backes
 */
public interface Reader {
    /**
     * Read the whole file and returns the content as ArrayList<String[]>.
     *
     * @return The content as an ArrayList<String[]>.
     */
    public ArrayList<String[]> readAll();
}
