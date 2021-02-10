package de.exxcellent.challenge;

/**
 * A simple interface to read a file.
 *
 * @author Philipp Backes
 */
public interface Reader {
    /**
     * Find a specific value depending on the indices.
     *
     * @param fileName Name of the file.
     * @param valueIndex Index of the value.
     * @param firstSub Index of the first subtraction value.
     * @param secondSub Index of the second subtraction value.
     * @return A value or an empty string.
     */
    String findValue(String fileName, int valueIndex, int firstSub, int secondSub);
}
