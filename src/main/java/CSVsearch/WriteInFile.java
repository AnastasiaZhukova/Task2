package CSVsearch;

import java.io.FileWriter;
import java.io.IOException;

public class WriteInFile {
    public static void WriteTXT(Search searchInfo, String filename)
    {
        FileWriter writer;
        try {
            writer=new FileWriter(filename,false);
        } catch (IOException e) {
            System.out.println("There are some problems while writing in file. Information was not written.");
            return;
        }

        int stringsSize=searchInfo.getNumberOfLines();

        String[] foundColumns=searchInfo.getColumnNumbers().split(" ");
        int foundColumnsSize=foundColumns.length;
        int currentColumn;
        for (int i=0; i<foundColumnsSize; i++)
        {
            currentColumn=Integer.parseInt(foundColumns[i]);
            for (int j=0; j<stringsSize; j++)
            {
                try {
                    //System.out.println(searchInfo.stringsArray.elementAt(j)[currentColumn]);
                    writer.append(searchInfo.stringsArray.elementAt(j)[currentColumn]);
                    writer.append("\r\n");
                } catch (IOException e) {
                    System.out.println("There are some problems while writing in file. Information is damaged.");
                }
            }

        }
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Problems while closing the file.");
        }

    }
}
