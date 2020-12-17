import com.opencsv.CSVReader;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseFullCSVExample
{
    @Test
    public static void main(String[] args) throws Exception
    {
        //Build reader instance
        CSVReader reader = new CSVReader(new FileReader("./Excel/6rows.csv"));

        //Read all rows at once
        List<String[]> allRows = reader.readAll();

        //Read CSV line by line and use the string array as you want
        for(String[] row : allRows){
            System.out.println(Arrays.toString(row));
        }
    }

    @Test
    public static void main2(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("./Excel/6rows.csv"));
        List<String> lines = new ArrayList<>();
        String line = null;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        System.out.println("linjer" +lines.get(0));
    }
}