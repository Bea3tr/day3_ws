package myfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class UniqueWordsMain {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        String inputFile = args[0];

        // Open inputFile for reading
        Reader reader = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(reader);

        // Create a set of string - does not allow duplicates
        // <> - generics
        Set<String> uniqueWords = new HashSet<String>();

        String line = "";
        while (null != line) {
            line = br.readLine();
            if (null == line)
                break;
                
            String transformed = line.replaceAll("\\p{Punct}", "").toLowerCase().trim();

            for (String word : transformed.split(" ")) {
                uniqueWords.add(word);
            }

            System.out.printf(">>> %s\n", transformed);   
        }
        // Close files
        reader.close();

        System.out.printf("Unique words in %s: %d\n", inputFile, uniqueWords.size());

        for (String word : uniqueWords) 
            System.out.printf("%s, ", word);
    }
}