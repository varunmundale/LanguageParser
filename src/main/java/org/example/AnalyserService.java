package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class AnalyserService {
    AnalysisResult analyse(String path){
        try (Stream<String> lines = Files.lines(Paths.get(path))){
            Analyser analyser = AnalyserFactory.getAnalyser(path);
            return analyser.analyse(lines);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        } catch (IOException e) {
            throw new RuntimeException("IO Exception");
        }
    }
}
