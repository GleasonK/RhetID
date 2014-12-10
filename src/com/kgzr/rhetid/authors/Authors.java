package com.kgzr.rhetid.authors;
import java.util.*;

/**
 * Created by GleasonK on 12/1/14.
 */
public class Authors {
    public static final String FILE_LOC_AUTH = "Authors/";
    public static final String HOMER         = "Homer";
    public static final String PLATO         = "Plato";
    public static final String SHAKESPEARE   = "William Shakespeare";
    public static final String SHAKESPEARE_SON="Shakespeare Sonnets";
    public static final String DANTE         = "Dante Alighieri";
    public static final String HEMMINGWAY    = "Ernest Hemingway";
    public static final String DOESTOYEVSKY  = "Fyodor Dostoevsky";
    public static final String AUSTEN        = "Jane Austen";
    public static final String FITZGERALD    = "Scott Fitzgerald";
    public static final String WOOLF         = "Virginia Woolf";

    public static Map<String,Double[]> authorList = new LinkedHashMap<String,Double[]>();

    static{
        authorList.put(HOMER,          AuthVectors.HOMER_VEC);
        authorList.put(PLATO,          AuthVectors.PLATO_VEC);
        authorList.put(SHAKESPEARE,    AuthVectors.SHAKESPEARE_VEC);
//        authorList.put(SHAKESPEARE_SON,AuthVectors.SHAKESPEARE_SON_V);
        authorList.put(DANTE,          AuthVectors.DANTE_VEC);
        authorList.put(HEMMINGWAY,     AuthVectors.HEMMINGWAY_VEC);
        authorList.put(DOESTOYEVSKY,   AuthVectors.DOESTOYEVSKY_VEC);
        authorList.put(AUSTEN,         AuthVectors.AUSTEN_VEC);
        authorList.put(FITZGERALD,     AuthVectors.FITZGERALD_VEC);
//        authorList.put(WOOLF,          AuthVectors.WOOLF_VEC);
    }

    public static Map<String, Double[]> getAuthors(){
        return authorList;
    }
}
