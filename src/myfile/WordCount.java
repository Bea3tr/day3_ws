package myfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        String inputFile = args[0];

        // Open inputFile for reading
        Reader reader = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(reader);

        // Create a map
        Map<String, Integer> uniqueWords = new HashMap<String, Integer>();

        String line = "";
        while (null != line) {
            line = br.readLine();
            if (null == line)
                break;
                
            String transformed = line.replaceAll("\\p{Punct}", "").toLowerCase().trim();

            for (String word : transformed.split(" ")) {

                int currentCount = 0;
                if (uniqueWords.containsKey(word)) {
                    currentCount = uniqueWords.get(word);
                }
                currentCount++;
                uniqueWords.put(word, currentCount);

                // if (uniqueWords.containsKey(word)) {
                //     // Word is in the list
                //     int currentCount = uniqueWords.get(word);
                //     currentCount++;
                //     uniqueWords.put(word, currentCount);
                // } else {
                //     // Word not in the list
                //     uniqueWords.put(word, 1);
                // }
            }
        }
        // Close files
        reader.close();

        System.out.println();
        for (String word : uniqueWords.keySet()) {
            System.out.printf("%s\t\t %d\n", word, uniqueWords.get(word));
        }
    }
}
