package CSVsearch;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class ReadCSV {
    private boolean isRead;
    private String CSVname;
    private StringBuilder CSVstatus = new StringBuilder();

    public Vector<String[]> read(String CSVfilename) {


        CSVReader csvReader;
        Vector<String[]> strings=new Vector<>();
        String[] infoArray;
        try {
            csvReader = new CSVReader(new FileReader(CSVfilename), ',', '"', 0);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }

        try {
            while ((infoArray = csvReader.readNext()) != null) {
                try {
                  strings.addElement(infoArray);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Out of Bounds");
                    return null;
                }catch (NullPointerException e) {
                    System.out.println("Null pointer");
                    return null;
                }

            }
        } catch (IOException e) {
            System.out.println("Error while reading CSV file");
            //e.printStackTrace();
        }
        isRead=true;
       return strings;
    }

    public boolean isRead() {
        return isRead;
    }

    public void getCSVstatus()
    {
        System.out.println(CSVstatus);
    }
}
