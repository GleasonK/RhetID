package com.kgzr.rhetid.score;

import com.kgzr.rhetid.authors.AuthVectors;
import com.kgzr.rhetid.authors.Authors;
import org.apache.commons.math3.ml.distance.EuclideanDistance;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by GleasonK on 12/4/14.
 */
public class VectorScoring {
    public static final double NN_WEIGHT  = 0.6799975663;
    public static final double PN_WEIGHT  = 4.736192959;
    public static final double PP_WEIGHT  = 1.909000339;
    public static final double VB_WEIGHT  = 1.692658593;
    public static final double JJ_WEIGHT  = 1.589359002;
    public static final double RB_WEIGHT  = 6.521776826;
    public static final double AvS_WEIGHT = 0.1931585684;
    public static final double AvP_WEIGHT = 0.7389976121;

    public static Map<String,Double> compareStats(Double[] vectorStat){
        Map<String,Double> authorsVals = new LinkedHashMap<String, Double>();
        Map<String,Double[]> authors = Authors.getAuthors();
        double max = 0d;
        //Get All scores relative to each other
        for(Map.Entry<String,Double[]> entry : authors.entrySet()){
            double score = getScore(vectorStat, entry.getValue());
            max = max < score ? score : max;
            authorsVals.put(entry.getKey(),score);
        }
        Set<Map.Entry<String,Double>> entries = authorsVals.entrySet();
        authorsVals = new LinkedHashMap<String, Double>();

        //ADD TWO POINTS FOR FORMATTING
        authorsVals.put("400 BC",0d);
        for(Map.Entry<String,Double> entry : entries){
            double score = -1 * entry.getValue() + max;
            authorsVals.put(entry.getKey(),score);
        }
        authorsVals.put("1940 AD",0d);

        //Invert Values and scale to 100.

        return authorsVals;
    }

    public static double getScore(Double[] v1, Double[] v2){
        EuclideanDistance euclideanDistance = new EuclideanDistance();
        double[] v1d = VectorScoring.weightVector(v1),
                v2d = VectorScoring.weightVector(v2);
        return euclideanDistance.compute(v1d,v2d);
    }

    public static double[] weightVector(Double[] vector){
        double nn_score = vector[0] * NN_WEIGHT;
        double pn_score = vector[1] * PN_WEIGHT;
        double pp_score = vector[2] * PP_WEIGHT;
        double vb_score = vector[3] * VB_WEIGHT;
        double jj_score = vector[4] * JJ_WEIGHT;
        double rb_score = vector[5] * RB_WEIGHT;
        double avs_score = vector[6]* AvS_WEIGHT;
        double avp_score = vector[7]* AvP_WEIGHT;
        return new double[] {nn_score, pn_score, pp_score, vb_score, jj_score, rb_score, avs_score, avp_score};
    }

}