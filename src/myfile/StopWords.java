package myfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class StopWords {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        String inputFile = args[0];
        String stopFile = args[1];

        // Open inputFile for reading
        Reader reader = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(reader);

        Reader readStop = new FileReader(stopFile);
        BufferedReader brs = new BufferedReader(readStop);

        // Create a list for stop words
        List<String> stopList = new LinkedList<String>();
        String w = "";
        while (null != w) {
            w = brs.readLine();
            if (null == w)
                break;
            stopList.add(w);
        }

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
                if (!stopList.contains(word)) {
                    if (uniqueWords.containsKey(word))
                        currentCount = uniqueWords.get(word);
                    currentCount++;
                    uniqueWords.put(word, currentCount);
                }
            }
        }
        // Close files
        reader.close();
        readStop.close();

        System.out.println();
        for (String word : uniqueWords.keySet()) {
            System.out.printf("%s\t\t %d\n", word, uniqueWords.get(word));
        }
    }
}

