package de.exxcellent.challenge.controller;

import java.util.ArrayList;

/**
 * A generic parser interface to parse content (e.g. text lines).
 *
 * @param <T> Could be any model type.
 *
 * @author Philipp Backes
 */
public interface Parser<T> {

    /**
     * Method to parse the content to an ArrayList<String[]>.
     *
     * @param content The content of a file.
     * @return An ArrayList with models of type T.
     */
    ArrayList<T> parse(ArrayList<String[]> content);
}
