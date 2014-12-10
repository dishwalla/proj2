/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondproj;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Class Application is the class, that processes all the logic of the project 
 */
public class Application {

    public static String allText;
    public static StringBuilder codeDump = new StringBuilder();
    public static List<Sentence> newList = new ArrayList<>();
    public static String vowels = "аоэиуыеёюя";
    public static Map<String, Double> wordsToSort = new HashMap<>();

    /*
     * runApplication method do the both tasks: read from file and after some logic implemented, write it back to other file
     */
    public static void runApplication(String path1, String path2, String path3) throws UnsupportedEncodingException, IOException {

        PrintWriter writer = null;
        PrintWriter writer2 = null;
        writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path2), "UTF-8"), true);
        Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream(path1)), "windows-1251");
        Application.allText = sc.useDelimiter("\\A").next();
        Application.allText = Application.allText.replaceAll("\t", " ");
        Application.allText = Application.allText.replaceAll("[ ][ ]+", " ");
        Application.newList = processText(Application.allText);
        System.out.println("Sorted by Vowels: " + sortByМowels());
        // System.out.println("Sorted by Vowels: " + sortByМowels().descendingMap());

        try {
            writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path2), "UTF-8"), true);
            writer2 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path3), "UTF-8"), true);
            for (Sentence s : Application.newList) {
                writer.write(s + "");
            }

            writer2.write(Application.codeDump.toString());

        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
                writer2.close();
                sc.close();
            } catch (Exception ex) {
            }
        }
    }

    /*
     * This method splits our input text with dot and returns it
     */
    public static List<Sentence> processText(String s) {
        List<Sentence> resultingList = new ArrayList<>();
        String[] sentences = s.split("\\.");
        for (String str : sentences) {
            resultingList.add(makeSentence(str + "."));
        }
        return resultingList;
    }

    /*
     * This method check units of the text and makes Word or Punctuation, making sentence in this way
     */
    public static Sentence makeSentence(String s) {
        Sentence result = new Sentence();
        String currentWord = "";
        for (Character ch : s.toCharArray()) {
            PartOfSentence current = null;
            if (Punctuation.codePuncts.contains(new String(new char[]{ch})) || ch == ' ' || ch == '\r' || ch == '\n') {
                if (!currentWord.isEmpty()) {
                    current = new Word(currentWord);
                    Application.wordsToSort.put(currentWord, Application.getRatio(currentWord));
                    addPsrtOfSent(current, result, currentWord);
                    currentWord = "";
                    current = new Punctuation(ch);
                    addPsrtOfSent(current, result, currentWord);
                }
            } else {
                currentWord += ch;
            }
        }
        result.addPartOfSentence(new Punctuation('.'));

        return result;

    }

    /*
     * This method check if some input is code or not and if it is, puts it to code storage
     */
    public static void addPsrtOfSent(PartOfSentence current, Sentence result, String currentWord) {
        if (!current.isCode()) {
            result.addPartOfSentence(current);
        } else {
            Application.codeDump.append(current + " ");
        }
    }

    /*
     * This simple method sorts our final text and returns it sorted according to our task
     */
    public static TreeMap<String, Double> sortByМowels() {
        ValueComparator vc = new ValueComparator(Application.wordsToSort);
        TreeMap<String, Double> sorted = new TreeMap<String, Double>(vc);
        sorted.putAll(Application.wordsToSort);
        return sorted;
    }
    
    /*
     * Main logic for task, that defines ratio of vawels in the Word
     */
    public static Double getRatio(String s) {
        int lenthOfWord = 0;
        int vawelsQuontity = 0;
        for (char ch : s.toCharArray()) {
            if (Application.vowels.contains(ch + "")) {
                vawelsQuontity++;
            } else if (ch == '.' || ch == ',' || ch == '!' || ch == '?') {
                lenthOfWord--;
            }

            lenthOfWord++;
        }
        double res = ((double) vawelsQuontity / lenthOfWord);
        return res;
    }

}
