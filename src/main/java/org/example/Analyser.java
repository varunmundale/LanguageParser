package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public abstract class Analyser {

    abstract LineTypeNode getLineType(String line);


    AnalysisResult analyse(BufferedReader reader) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        int blank = 0;
        int comments = 0;
        int code = 0;
        int total = 0;

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
        map.put("Blank", blank);
        map.put("Comment", comments);
        map.put("Code", code);
        map.put("Total", total);


        return new AnalysisResult(map);
    }

}
