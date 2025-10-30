package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnalyserTest {

    boolean resultEquals(AnalysisResult analysisResultExpected, AnalysisResult analysisResultActual){
        Assertions.assertEquals(analysisResultExpected.blanks(), analysisResultActual.blanks());
        Assertions.assertEquals(analysisResultExpected.comments(), analysisResultActual.comments());
        Assertions.assertEquals(analysisResultExpected.codeLines(), analysisResultActual.codeLines());
        Assertions.assertEquals(analysisResultExpected.total(), analysisResultActual.total());
        return true;
    }
    @Test
    void testJavaFile() {
        String path = "src/main/resources/Main.java";
        AnalysisResult analysisResult = new AnalyserService().analyse(path);
        System.out.println(analysisResult);
        AnalysisResult expectedResult = new AnalysisResult()
                .setBlanks(3)
                .setComments(3)
                .setCodeLines(6)
                .setTotal(12);
        Assertions.assertTrue( resultEquals(expectedResult,analysisResult));

    }
}