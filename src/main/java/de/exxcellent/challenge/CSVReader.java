package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * A reader for CSV files.
 *
 * @author Philipp Backes
 */
public class CSVReader implements Reader {

    @Override
    public String findValue(String fileName, int valueIndex, int firstSub, int secondSub) {
        String value = "";
        int lastAbsoluteDifference = Integer.MAX_VALUE;
        String row = "";
        try {
            String path = getClass().getResource(fileName).getFile();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while ((row = bufferedReader.readLine()) != null) {
                if(value.equals("")) row = bufferedReader.readLine(); // Skip first row
                String[] data = row.split(",");
                int absoluteDifference = Math.abs(Integer.parseInt(data[firstSub]) - Integer.parseInt(data[secondSub]));
                if (absoluteDifference < lastAbsoluteDifference) {
                    value = data[valueIndex];
                    lastAbsoluteDifference = absoluteDifference;
                }
            }
            bufferedReader.close();
        }
        catch(Exception e) { // Handle multiple exceptions at once
            System.out.println("Check if the file exists and the content allows to return a value!");
            e.printStackTrace();
        }
        return value;
    }
}
