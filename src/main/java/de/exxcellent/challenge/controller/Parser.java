package de.exxcellent.challenge.controller;

import java.util.List;

/**
 * A generic parser interface to parse content (e.g. text lines).
 *
 * @param <T> Could be any model type.
 *
 * @author Philipp Backes
 */
public interface Parser<T> {

    /**
     * Method to parse the content to a List<String[]>.
     *
     * @param content The content of a file.
     * @return A list with models of type T.
     */
    List<T> parse(List<String[]> content);
}
