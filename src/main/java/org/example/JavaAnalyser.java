package org.example;

public class JavaAnalyser extends Analyser {
    @Override
    protected LineTypeNode getLineType(String rawLine) {
        String line = rawLine.trim();
        LineType type =null;
        if (line.isEmpty()) type = LineType.BLANK;
        else if (line.startsWith("//")) type = LineType.COMMENT;
        else type = LineType.CODE;
        return new LineTypeNode(type);
    }
}
