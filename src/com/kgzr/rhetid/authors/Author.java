package com.kgzr.rhetid.authors;

import com.kgzr.rhetid.elements.adt.Punctuation;
import com.kgzr.rhetid.elements.adt.RhetAnalysis;

import java.util.Arrays;
import java.util.List;

/**
 * Created by GleasonK on 12/1/14.
 */
public class Author {
    private String name;
    private Double[] vectorStat;
    private RhetAnalysis rhetAnalysis;

    public Author(String name, RhetAnalysis rhetAnalysis){
        this.name=name;
        this.rhetAnalysis=rhetAnalysis;
        makeVector();
    }

    public Author(String name, Double[] vectorStat){
        this.name=name;
        this.vectorStat=vectorStat;
    }

    public void makeVector(){
        RhetAnalysis rh = this.rhetAnalysis;
        Double[] vector = {rh.getNnPerSent(), rh.getPnPerSent(), rh.getPpPerSent(), rh.getVbPerSent(),
                rh.getAdjPerSent(), rh.getAdvPerSent(), rh.getAvgSentLength(), rh.getAvgParaLength()};
        this.vectorStat=vector;
    }

    public String printVector(){
        List<Double> vector = Arrays.asList(this.vectorStat);
        return vector.toString();
    }

    public String getName() {
        return name;
    }

    public RhetAnalysis getRhetAnalysis() {
        return rhetAnalysis;
    }

    public Double[] getVectorStat() {
        return vectorStat;
    }
}
