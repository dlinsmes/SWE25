import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVImporter {

    public static ArrayList<String []> importData(String filename) {
        ArrayList<String [] > data = new ArrayList<String []>();

        try {
            File f = new File(filename);
            Scanner s = new Scanner(f);

            while(s.hasNextLine()) {
                String line = s.nextLine();
                String [] dataRow = line.split(",");
                data.add(dataRow);
            }

        }
        catch(Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }


        return data;
    }


}