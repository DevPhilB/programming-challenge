package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A simple reader for CSV files.
 *
 * @author Philipp Backes
 */
public class CSVReader implements Reader {

    private final String filePath;

    /**
     * Constructor expect a valid file path.
     *
     * @param filePath Valid CSV file path.
     */
    public CSVReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public ArrayList<String[]> readAll() {
        ArrayList<String[]> content = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String row;
            bufferedReader.readLine(); // Skip first row
            while ((row = bufferedReader.readLine()) != null) {
                content.add(row.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
