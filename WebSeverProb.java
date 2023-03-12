package rao_codefest;

import java.io.*;
import java.util.*;
 
public class WebSeverProb{
 
    public static void main(String[] args) {
        List<List<Integer>> websites = new ArrayList<>();
        
        int numberOfWebsite = 0;

        //input file reading
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/ISHA/Desktop/TWSP_small.txt"))) {
            numberOfWebsite = Integer.parseInt(br.readLine().trim());
            String line;
            while ((line = br.readLine()) != null) {
                List<Integer> website = new ArrayList<>();
                for (String s: Arrays.asList(line.trim().split("\\s+"))) {
                    website.add(Integer.parseInt(s));
                }
                websites.add(website);            
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //using compareWebsites function
        for (int i = 0; i < websites.size(); i++) {
            for (int j = 0; j < websites.size() - i - 1; j++) {
                List<Integer> websiteA = websites.get(j);
                List<Integer> websiteB = websites.get(j + 1);
                List<Integer> minWebsite = compareWebsites(websiteA, websiteB);
                if (minWebsite == websiteB) {
                    websites.set(j + 1, websiteA);
                    websites.set(j, websiteB);
                }
            }
        }
        
        //printing output in form of list
        // for(int i=0; i<websites.size(); i++){
        //     System.out.println(websites.get(i));
        // }

        //printing output and removing brackets from list
        for(int i=0; i<websites.size(); i++){
            System.out.println(websites.get(i).toString().replace("[","").replace("]","").replace(" ",""));
        }

    }
    
    //compare function which returns sorted website
    //sorting website -> minimimum content, maximum image, minimum forms
    static List<Integer> compareWebsites(List<Integer> websiteA, List<Integer> websiteB) {
        if (websiteA.get(0).equals(websiteB.get(0))) {
            if (websiteA.get(1).equals(websiteB.get(1))) {
                if (websiteA.get(2).equals(websiteB.get(2))) {
                    return websiteA;
                } 
                else if (websiteA.get(2) > websiteB.get(2)) {
                    return websiteB;
                } 
                else {
                    return websiteA;
                }
            } 
            else if (websiteA.get(1) > websiteB.get(1)) {
                return websiteA;
            } 
            else {
                return websiteB;
            }
        } 
        else if (websiteA.get(0) > websiteB.get(0)) {
            return websiteB;
        } 
        else {
            return websiteA;
        }
    }
}

