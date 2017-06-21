import CSVsearch.ReadCSV;
import CSVsearch.Search;
import CSVsearch.WriteInFile;


public class MainClass {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Wrong number of arguments. Notice: CSVfile SearchString FinalFilename");
            System.exit(0);
        }
        String CSV = args[0];
        String find = args[1];
        String filename = args[2];
        System.out.println("CSV FILE: " + CSV);
        System.out.println("SEARCH STRING: " + find);
        System.out.println("FILE NAME: " + filename);
        System.out.println();


        Search CSVsearch = new Search();
        ReadCSV readCSV = new ReadCSV();
        CSVsearch.stringsArray = readCSV.read(CSV);
        if (readCSV.isRead()) {
            CSVsearch.search(find);
            if (CSVsearch.isFound()) {
                WriteInFile.WriteTXT(CSVsearch, filename);
            } else {
                System.out.println("Nothing was found");
            }


        } else {
            System.out.println("Couldn't read CSV file");
        }
        System.out.println("Finished");

    }
}
