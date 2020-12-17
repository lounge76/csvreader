import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class BufferReader
{
    @Test
    public static void main(String[] args) throws Exception
    {
        //Build reader instance
        BufferedReader reader = new BufferedReader(new FileReader("./Excel/6rows.csv"));

        List<String> lines = new ArrayList<>();
        String line = null;
        while ((line = reader.readLine()) != null) {
            lines.add(line);


        }
        System.out.println("Specific line: " +lines.get(2));
        }
}

