package org.example;

import java.util.HashMap;
import java.util.Map;

public class AnalysisResult {
    private int blanks;
    private int comments;
    private int codeLines;
    private int total;




    @Override
    public String toString() {
        String result = "";
        result =  result + "Blank: " +  blanks + '\n';
        result =  result + "Comment: " +  comments + '\n';
        result =  result + "Code: " +  codeLines + '\n';
        result =  result + "Total: " +  total + '\n';

        return result;
    }


    public AnalysisResult setBlanks(int blanks) {
        this.blanks = blanks;
        return this;
    }

    public AnalysisResult setComments(int comments) {
        this.comments = comments;
        return this;
    }

    public AnalysisResult setCodeLines(int codeLines) {
        this.codeLines = codeLines;
        return this;
    }

    public AnalysisResult setTotal(int total) {
        this.total = total;
        return this;
    }

    public int blanks() {
        return blanks;
    }

    public int comments() {
        return comments;
    }

    public int codeLines() {
        return codeLines;
    }

    public int total() {
        return total;
    }
}
