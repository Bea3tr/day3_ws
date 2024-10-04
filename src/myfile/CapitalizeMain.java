package myfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CapitalizeMain {

    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        String inputFile = args[0];
        String outputFile = args[1];

        // Open inputFile for reading
        Reader reader = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(reader);

        // Open outputFile for writing
        Writer writer = new FileWriter(outputFile);
        BufferedWriter bw = new BufferedWriter(writer);

        String line = "";
        while (null != line) {
            line = br.readLine();
            if (null == line)
                break;
            
            // Write to file
            bw.write(line.toUpperCase() + "\n");
            writer.flush();
        }

        // Flush remaining data to file
        // bw.flush();

        // Close files
        reader.close();
        bw.close();
        writer.close();
    }
    
}
