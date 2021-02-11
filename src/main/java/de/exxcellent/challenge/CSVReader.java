package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * A simple reader for CSV files.
 *
 * @author Philipp Backes
 */
public class CSVReader implements Reader {

    // Enables efficient reading of text data.
    private BufferedReader bufferedReader;

    /**
     * Constructor expect a valid file path.
     *
     * @param filePath Valid CSV file path.
     */
    public CSVReader(String filePath){
        try {
            this.bufferedReader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<String[]> readAll() {
        ArrayList<String[]> content = new ArrayList<>();
        try {
            String row;
            bufferedReader.readLine(); // Skip first row
            while ((row = bufferedReader.readLine()) != null) {
                content.add(row.split(","));
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
}
