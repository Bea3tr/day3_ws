package myfile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class ReadWrite {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        // Read file
        FileReader readFile = new FileReader(args[0]);
        // For more efficient implementation of read()/readLine()
        BufferedReader buffered = new BufferedReader(readFile);

        // Write file
        FileWriter output = new FileWriter("OUTPUT.txt");
        BufferedWriter bOutput = new BufferedWriter(output);

        while (buffered.ready()) {
            String line = buffered.readLine().toUpperCase() + "\n";
            bOutput.write(line);
        }
        readFile.close();
        output.close();
    }   
}