package de.exxcellent.challenge;

import java.util.List;

/**
 * An interface to read single files at once.
 *
 * @author Philipp Backes
 */
public interface Reader {

    /**
     * Read the whole file and returns the content as List<String[]>.
     *
     * @return The content as a List<String[]>.
     */
    List<String[]> readAll();
}
