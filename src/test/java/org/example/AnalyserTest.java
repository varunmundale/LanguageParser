package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



import java.util.HashMap;
import java.util.Map;

class AnalyserTest {

    boolean resultEquals(AnalysisResult analysisResultExpected, AnalysisResult analysisResultActual){
        var expectedMap = analysisResultExpected.map;
        var actualMap = analysisResultActual.map;
        for( var key : expectedMap.keySet()){
            Assertions.assertEquals(expectedMap.get(key), actualMap.get(key));
        }
        return true;
    }
    @Test
    void testJavaFile() {
        String path = "src/main/resources/Main.java";
        Analyser analyser = AnalyserFactory.getAnalyser(path);
        AnalysisResult analysisResult = analyser.analyse(path);
        System.out.println(analysisResult);
        AnalysisResult expectedResult = new AnalysisResult(
                new HashMap<>(Map.of("Blank",3,"Comment",3, "Code",6,"Total",12))
        );
        Assertions.assertTrue( resultEquals(expectedResult,analysisResult));

    }
}