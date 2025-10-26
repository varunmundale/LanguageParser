package org.example;

import java.util.HashMap;
import java.util.Map;

public class AnalysisResult {
    Map<String, Integer> map;
    AnalysisResult(Map<String, Integer> map){
        this.map = map;
    }


    @Override
    public String toString() {
        String result = "";
        for ( var key: map.keySet()){
            System.out.println(key + ": "+ map.get(key));
        }
        return result;
    }
}
