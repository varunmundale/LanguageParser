package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public abstract class Analyser {
    abstract LineTypeNode getLineType(String line);

    AnalysisResult analyse(String filePath){
        Map<String, Integer> map = new HashMap<>();
        int blank = 0;
        int comments = 0;
        int code = 0;
        int total = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                LineType type = getLineType(line).type;
                if (type == LineType.BLANK) {
                    blank++;
                } else if (type == LineType.COMMENT) {
                    comments++;
                } else if (type == LineType.CODE) {
                    code++;
                }
                total++;
            }
            //populate all metrics
            map.put("Blank",blank);
            map.put("Comment",comments);
            map.put("Code",code);
            map.put("Total", total);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + filePath, e);
        }

        return new AnalysisResult(map);
    }

}
