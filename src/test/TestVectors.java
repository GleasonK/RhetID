package test;

import com.kgzr.rhetid.authors.AuthVectors;
import com.kgzr.rhetid.authors.Authors;
import com.kgzr.rhetid.score.VectorScoring;
import org.apache.commons.math3.ml.distance.EuclideanDistance;

/**
* Created by Kevin and Zach on 12/3/14.
*/
public class TestVectors {




    public static void main(String[] args) {

        System.out.println("SHK->HAM: " + VectorScoring.getScore(AuthVectors.SHAKESPEARE_VEC, SampleData.SH_HAMLET));
        System.out.println("SHK->MAC: " + VectorScoring.getScore(AuthVectors.SHAKESPEARE_VEC, SampleData.SH_MACBETH));
        System.out.println("SHK->PRI: " + VectorScoring.getScore(AuthVectors.SHAKESPEARE_VEC, SampleData.JA_PRIDE));
        System.out.println("SHK->MOB: " + VectorScoring.getScore(AuthVectors.SHAKESPEARE_VEC, SampleData.HM_MOBY));
        System.out.println();
        System.out.println("JAA->EMM: " + VectorScoring.getScore(AuthVectors.AUSTEN_VEC, SampleData.JA_EMMA));
        System.out.println("JAA->PRI: " + VectorScoring.getScore(AuthVectors.AUSTEN_VEC, SampleData.JA_PRIDE));
        System.out.println("JAA->HAM: " + VectorScoring.getScore(AuthVectors.AUSTEN_VEC, SampleData.SH_HAMLET));
        System.out.println("JAA->MOB: " + VectorScoring.getScore(AuthVectors.AUSTEN_VEC, SampleData.HM_MOBY));


    }
}
