package org.example;

import java.io.*;

public class AnalyserService {
    AnalysisResult analyse(String path){
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            Analyser analyser = AnalyserFactory.getAnalyser(path);
            return analyser.analyse(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        } catch (IOException e) {
            throw new RuntimeException("IO Exception");
        }
    }
}
