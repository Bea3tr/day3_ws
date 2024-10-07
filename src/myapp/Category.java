package myapp;

import java.util.HashMap;

public class Category {


    public HashMap<String, String[]> highest(HashMap<String, HashMap<String, Float>> overall) {

        HashMap<String, String[]> hList = new HashMap<String, String[]>();

        for(String category : overall.keySet()) {
            String[] result = new String[2];
            float max = 0f;
            String hApp = "";
            HashMap<String, Float> rate = overall.get(category);
            for(String app : rate.keySet()) {
                if(rate.get(app) > max) {
                    max = rate.get(app);
                    hApp = app;
                }
            }
            result[0] = hApp;
            result[1] = String.valueOf(max);
            hList.put(category, result);
        }
        return hList;
    }

    public HashMap<String, String[]> lowest(HashMap<String, HashMap<String, Float>> overall) {

        HashMap<String, String[]> lList = new HashMap<String, String[]>();

        for(String category : overall.keySet()) {
            String[] result = new String[2];
            float min = 5;
            String lApp = "";
            HashMap<String, Float> rate = overall.get(category);
            for(String app : rate.keySet()) {
                if(rate.get(app) < min) {
                    min = rate.get(app);
                    lApp = app;
                }
            }
            result[0] = lApp;
            result[1] = String.valueOf(min);
            lList.put(category, result);
        }
        return lList;
    }

    public HashMap<String, Float> average(HashMap<String, HashMap<String, Float>> overall) {

        HashMap<String, Float> avg = new HashMap<String, Float>();

        for(String category : overall.keySet()) {
            float total = 0f;
            HashMap<String, Float> rate = overall.get(category);
            for(String app : rate.keySet()) {
                total += rate.get(app);
            }
            avg.put(category, total/rate.size());
        }
        return avg;
    }
    
}
