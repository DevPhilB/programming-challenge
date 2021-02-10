package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * A reader for CSV files.
 *
 * @author Philipp Backes
 */
public class CSVReader {

    /**
     * Returns the day number of the day with the smallest temperature spread in a CSV file.
     *
     * @param  fileName Name of the CSV file.
     * @return String Day with the smallest temperature spread.
     */
    public String getSmallestTemperatureSpreadDay(String fileName)
    {
        String day = "";
        int lastSpread = Integer.MAX_VALUE;
        String row = "";
        // Handle IO Exceptions
        try {
            String path = getClass().getResource(fileName).getFile();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while ((row = bufferedReader.readLine()) != null) {
                if(day.equals("")) row = bufferedReader.readLine(); // Skip first row
                String[] data = row.split(",");
                if (Integer.parseInt(data[1]) - Integer.parseInt(data[2]) < lastSpread) {
                    day = data[0];
                    lastSpread = Integer.parseInt(data[1]) - Integer.parseInt(data[2]);
                }
            }
            bufferedReader.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return day;
    }
}
