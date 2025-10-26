package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnalyserFactory {

    public static Analyser getAnalyser(String filePath) {
        String ext = getExtension(filePath).toLowerCase();

        switch (ext) {
            case "java": return new JavaAnalyser();
            default: throw new UnsupportedOperationException("Unsupported file type: " + ext);
        }
    }

    private static String getExtension(String path) {
        //assume valid path
         String lastToken = Arrays.stream(path.split("/")).toList().getLast();
         String extension = Arrays.stream(lastToken.split("\\.")).toList().getLast();
         return extension;
    }
}

