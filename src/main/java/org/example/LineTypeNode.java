package org.example;

public class LineTypeNode {
    LineType type;
    LineTypeNode subLineTypeNode = null;
    public LineTypeNode(LineType type){
        this.type = type;
    }
}
