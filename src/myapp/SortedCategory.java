package myapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SortedCategory {
    /*
     * For every category, display the following
     * Category name
     * Highest rated app name & rating
     * Lowest rated app name & rating
     * Average rating for the category
     */

     public static void main(String[] args) {

        Category c = new Category();
        HashMap<String, HashMap<String, Float>> overall = new HashMap<String, HashMap<String, Float>>();

        try {
            Reader file = new FileReader("googleplaystore.csv");
            BufferedReader br = new BufferedReader(file);
            String row = br.readLine();
            

            while(null != row) {
                row = br.readLine();
                if(null == row)
                    break;
                String[] details = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                // System.out.println(details[0] + details[1] + details[2]);

                // Put category & details into map: 0-app, 1-category, 2-rating
                if(!details[2].equals("NaN")) {
                    if(!overall.containsKey(details[1])) {
                        HashMap<String, Float> ratings = new HashMap<String, Float>();
                        // System.out.println(details[2]);
                        float rating = Float.parseFloat(details[2]);
                        ratings.put(details[0], rating);
                        overall.put(details[1], ratings);
                    }else {
                    float rating = Float.parseFloat(details[2]);
                    HashMap<String, Float> ratings = overall.get(details[1]);
                    ratings.put(details[0], rating);
                    overall.put(details[1], ratings);
                    }
                }
            }
            br.close();

            TreeMap<String, String[]> hList = c.highest(overall);
            for(String category : hList.keySet()) {
                System.out.printf("App with highest rating in %s category: %s (%s)\n", category, hList.get(category)[0], hList.get(category)[1]);
            }

            TreeMap<String, String[]> lList = c.lowest(overall);
            for(String category : lList.keySet()) {
                System.out.printf("App with lowest rating in %s category: %s (%s)\n", category, lList.get(category)[0], lList.get(category)[1]);
            }

            TreeMap<String, Float> avg = c.average(overall);
            for(String category : avg.keySet()) {
                System.out.printf("Average rating in %s category: %f\n", category, avg.get(category));
            }


            /*
            // Highest & lowest rating
            for(String category : overall.keySet()) {
                float total = 0f;
                float max = 0f;
                float min = 5;
                String hApp = "";
                String lApp = "";
                HashMap<String, Float> rate = overall.get(category);
                for(String app : rate.keySet()) {
                    if(rate.get(app) > max) {
                        max = rate.get(app);
                        hApp = app;
                    }
                    if(rate.get(app) < min) {
                        min = rate.get(app);
                        lApp = app;
                    }
                    total = total + rate.get(app);
                }
                System.out.printf("App with highest rating in %s category: %s (%f)\n", category, hApp, max);
                System.out.printf("App with lowest rating in %s category: %s (%f)\n", category, lApp, min);
                System.out.printf("Average rating in %s category: %f\n", category, total/rate.size());
            }*/
        } catch(FileNotFoundException e) {
            System.out.println("File does not exist");
        } catch(IOException e) {
            System.out.println("Input / Output error");
        }
     }
}
