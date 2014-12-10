package com.kgzr.rhetid.score;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by GleasonK on 12/6/14.
 */
public class AuthScores {
    private Map<String,double[]> authorScores = new HashMap<String, double[]>();

    public void addScore(String author, double[] vector){
        this.authorScores.put(author,vector);
    }

    public Map<String,double[]> getScores(){
        return authorScores;
    }
}
