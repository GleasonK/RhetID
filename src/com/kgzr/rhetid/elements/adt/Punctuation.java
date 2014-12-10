package com.kgzr.rhetid.elements.adt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin and Zach on 12/1/14.
 * TODO: Consider relational database
 * Count the number of punctuations in a paragraph.
 */
public class Punctuation {
    private int periods     = 0;
    private int questions   = 0;
    private int exclamation = 0;
    private int commas      = 0;
    private int dashes      = 0;
    private int semicolon   = 0;
    private int quotes      = 0;
    private int paragraphs  = 0;

    private double avgPeriods     = 0d;
    private double avgQuestions   = 0d;
    private double avgExclamation = 0d;
    private double avgCommas      = 0d;
    private double avgDashes      = 0d;
    private double avgSemicolon   = 0d;
    private double avgQuotes      = 0d;
    private double avgParagraphs  = 0d;

    private int count = 0;

    public void add(String s){
        this.count++;
        switch (s.charAt(0)){
            case ('.'):
                periods++;
                return;
            case ('?'):
                questions++;
                return;
            case ('!'):
                exclamation++;
                return;
            case (','):
                commas++;
                return;
            case ('-'):
                dashes++;
                return;
            case (';'):
                semicolon++;
                return;
            case ('"'):
                quotes++;
                return;
            default:
                return;
        }
    }

    public int getPeriods(){     return this.periods; }
    public int getQuestions(){   return this.questions; }
    public int getExclamation(){ return this.exclamation; }
    public int getCommas(){      return this.commas; }
    public int getDashes(){      return this.dashes; }
    public int getSemicolon(){   return this.semicolon; }
    public int getQuotes(){      return this.quotes;}

    public int getCount(){ return this.count; }

    public void calculateAverages(double words){
        avgPeriods     = periods/words;
        avgQuestions   = questions/words;
        avgExclamation = exclamation/words;
        avgCommas      = commas/words;
        avgDashes      = dashes/words;
        avgSemicolon   = semicolon/words;
        avgQuotes      = quotes/words;
        avgParagraphs  = paragraphs/words;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(". "  + this.avgPeriods + "\n");
        sb.append("? "  + this.avgQuestions + "\n");
        sb.append("\" " + this.avgQuotes + "\n");
        sb.append("! "  + this.avgExclamation + "\n");
        sb.append("-- " + this.avgDashes + "\n");
        sb.append("; "  + this.avgSemicolon + "\n");
        sb.append(", "  + this.avgCommas + "\n");
        return sb.toString();
    }

}
