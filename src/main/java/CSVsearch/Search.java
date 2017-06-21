package CSVsearch;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {
    public Vector<String[]> stringsArray;
    private int numberOfLines;
    private int numberOfColumns;
    private String foundColumns;
    private boolean isfound=false;


    public void search(String searchString) {
        numberOfLines = stringsArray.size();
        numberOfColumns = minimumSizeOfColumns();

        StringBuilder columnNumbers = new StringBuilder();
        Pattern p = Pattern.compile(searchString);
        Matcher m;
        for (int j = 0; j < numberOfColumns; j++) {
            for (int i = 0; i < numberOfLines; i++) {
                m = p.matcher(stringsArray.elementAt(i)[j]);
                if (m.matches()) {
                    columnNumbers.append(j + " ");
                    isfound=true;
                    break;
                }
            }
        }
        this.foundColumns = columnNumbers.toString();
    }


    public int minimumSizeOfColumns() {
        numberOfLines = stringsArray.size();
        int minimum = stringsArray.elementAt(0).length;
        int length;
        for (int i = 1; i < numberOfLines; i++) {
            length = stringsArray.elementAt(i).length;
            if (length < minimum) {
                System.out.println("String №"+i+" is damaged. Some data may be lost");
                minimum = length;
            }
        }
        return minimum;
    }

    public int getNumberOfLines() {
        numberOfLines = stringsArray.size();
        return numberOfLines;
    }

    public String getFoundColumns()
    {
        return foundColumns;
    }

    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public boolean isFound()
    {
        return isfound;
    }
}
