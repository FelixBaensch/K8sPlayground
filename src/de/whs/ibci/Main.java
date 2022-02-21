package de.whs.ibci;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class Main {

//    public static void main(String[] args) {
//        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
//
//        int tmpResult = -1;
//        File tmpOutputFile = new File("./"+System.getenv("OUTPUT_PATH") +"/output"+ System.getenv("JOB_ID") +".txt");
//        try {
//            String tmpClassPath = System.getProperty("java.class.path");
//            System.out.println("Class path: " + tmpClassPath);
//
//            File tmpInputFile = new File("./input/input" + System.getenv("JOB_ID") + ".txt");
//            tmpResult = readFileAndAddOne(tmpInputFile);
//
//            File tmpOutputDir = new File("./" + System.getenv("OUTPUT_PATH"));
//            if(!tmpOutputDir.exists()){
//                tmpOutputDir.mkdir();
//            }
//            PrintWriter tmpWriter = new PrintWriter(tmpOutputFile, "UTF-8");
//            tmpWriter.println(tmpResult);
//            tmpWriter.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        System.out.println("Result: " + tmpResult);
//    }

    public static void main(String[] args) {
        System.out.println(System.getenv("JOB_COMPLETION_INDEX"));

        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());

        int tmpResult = -1;
        File tmpOutputFile = new File("./"+System.getenv("OUTPUT_PATH") +"/output"+ System.getenv("JOB_ID") +".txt");
        try {
            String tmpClassPath = System.getProperty("java.class.path");
            System.out.println("Class path: " + tmpClassPath);

            File tmpInputFile = new File("./input/input" + System.getenv("JOB_ID") + ".txt");
            tmpResult = readFileAndAddOne(tmpInputFile);

            File tmpOutputDir = new File("./" + System.getenv("OUTPUT_PATH"));
            if(!tmpOutputDir.exists()){
                tmpOutputDir.mkdir();
            }
            PrintWriter tmpWriter = new PrintWriter(tmpOutputFile, "UTF-8");
            tmpWriter.println(tmpResult);
            tmpWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Result: " + tmpResult);
    }

    private static int readFileAndAddOne(File aFile){
        int tmpSum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(aFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.isBlank())
                    continue;
                int tmpValue = Integer.parseInt(line);
                tmpSum = tmpValue + 1;
            }
            return tmpSum;
        } catch (IOException e) {
            System.out.println(e.toString());
            return -1;
        }
    }
}
