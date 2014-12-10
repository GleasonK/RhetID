package com.kgzr.rhetid.pos.util;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by GleasonK on 12/1/14.
 */
public class PosTags {
    public static final Set<String> ADVERB       = new HashSet<String>();
    public static final Set<String> ADJECTIVE    = new HashSet<String>();
    public static final Set<String> PRONOUN      = new HashSet<String>();
    public static final Set<String> NOUN         = new HashSet<String>();
    public static final Set<String> PROPER_NOUN  = new HashSet<String>();
    public static final Set<String> VERB         = new HashSet<String>();
    public static final Set<String> DETERMINER   = new HashSet<String>();
    public static final Set<String> PUNCTUATION_END = new HashSet<String>();
    public static final Set<String> PUNCTUATION_ALL = new HashSet<String>();

    static {
        PRONOUN.add("PP");
        ADVERB.add("RB");
        ADJECTIVE.add("JJ");
        ADJECTIVE.add("JJS");
        ADJECTIVE.add("JJR");
        ADJECTIVE.add("VBN");
        NOUN.add("NN");
        NOUN.add("NNS");
        NOUN.add("VBG");
        PROPER_NOUN.add("NP");
        VERB.add("VBD");
        VERB.add("VBP");
        VERB.add("VBZ");
        VERB.add("VB");
        DETERMINER.add("DT");
        PUNCTUATION_END.add(".");
        PUNCTUATION_ALL.add(".");
        PUNCTUATION_ALL.add("(");
        PUNCTUATION_ALL.add(")");
        PUNCTUATION_ALL.add(",");
        PUNCTUATION_ALL.add(":");
        PUNCTUATION_ALL.add("#");
        PUNCTUATION_ALL.add("''");
    }
//    public static final String
//    public static final String
//    public static final String
//    public static final String
//    public static final String
//    public static final String
//    public static final String
//    public static final String

    public static void main(String[] args) {
    }
}
