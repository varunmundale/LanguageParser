package org.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

public abstract class Analyser {

    abstract LineTypeNode getLineType(String line);


    AnalysisResult analyse(Stream<String> lines) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        int blanks = 0;
        int comments = 0;
        int codeLines = 0;
        int total = 0;

        Iterator<String> iterator = lines.iterator();
        while (iterator.hasNext()) {
            String line = iterator.next();
            LineType type = getLineType(line).type;
            if (type == LineType.BLANK) {
                blanks++;
            } else if (type == LineType.COMMENT) {
                comments++;
            } else if (type == LineType.CODE) {
                codeLines++;
            }
            total++;
        }
        //populate all metrics
        AnalysisResult analysisResult = new AnalysisResult()
                .setBlanks(blanks)
                .setComments(comments)
                .setCodeLines(codeLines)
                .setTotal(total);

        return analysisResult;
    }

}
