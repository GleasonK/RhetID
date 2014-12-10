package com.kgzr.rhetid;

import com.kgzr.rhetid.authors.Author;
import com.kgzr.rhetid.authors.Authors;
import com.kgzr.rhetid.elements.adt.RhetAnalysis;
import com.kgzr.rhetid.pos.adt.TaggedWord;
import com.kgzr.rhetid.pos.adt.Tagger;
import com.kgzr.rhetid.pos.taggers.Viterbi;
import com.kgzr.rhetid.pos.util.BankLoader;
import com.kgzr.rhetid.score.VectorScoring;
import com.kgzr.rhetid.util.StopWords;
import sun.font.TrueTypeFont;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Kevin and Zach on 11/30/14.
 * The Main file for the RhetID Application. This is used to incorporate the logic of all packages.
 */
public class RhetIdApp {
    static{ loadStaticAssets(); }
    public static final boolean DEBUG = true;
    /**
     * Load the static assets.
     * Current files includes:
     * <ul>
     *     <li>POS Tagger tree bank</li>
     *     <li>StopWords lookup map</li>
     * </ul>
     */
    public static void loadStaticAssets(){
        BankLoader.readFiles();
        if (RhetIdApp.DEBUG){ System.out.println("Loaded TreeBank"); }

        StopWords.loadStopWords();
        if (RhetIdApp.DEBUG) {
            System.out.println("Loaded StopWords.");
            System.out.println("StopWords: " + StopWords.getStopWords().toString());
        }

//        Authors.loadAuthors();
    }

    /**
     * Text Data
     * @param textData
     */
    public static Author runWebApp(Scanner textData){
        //Read the File
        List<List<String>> fileLines = BankLoader.readUntaggedData(textData);

        //Tag The Lines
        Tagger tagger = new Viterbi();
        List<List<TaggedWord>> taggedSentences = tagger.tag(fileLines);
        RhetAnalysis rhetAnalysis = new RhetAnalysis();

        /**
         * boolean for paragraph counting. If there are more than one line breaks in a row,
         this boolean is switched to false to avoid over-counting the number of paragraphs
         */
        boolean notIncremented = true;
        for (List<TaggedWord> sentence : taggedSentences){
            if (sentence.isEmpty() && notIncremented){
                rhetAnalysis.incrementParagraph();
                notIncremented = false;
            }
            else{
                notIncremented = true;
            }
            for (TaggedWord taggedWord : sentence){
                rhetAnalysis.add(taggedWord);
            }
        }
        rhetAnalysis.calculateAverages();
//        System.out.println(rhetAnalysis.toString());
//        System.out.println(rhetAnalysis.getPunctuation().toString());

        Author userAuthor = new Author("USER", rhetAnalysis);
//        System.out.println(userAuthor.printVector());

//        System.out.println(scores);
        return userAuthor;
    }

    /**
     * runApp put here to keep the main function clean for development.
     * Will be moved later.
     *
     * Processes in runapp:
     * <ul>
     *     <li>Read in File</li>
     *     <li>Tokenize</li>
     *     <li>Zipf and KeyWordZipf</li>
     *     <li>POS Tagging</li>
     *     <li>RhetAnalysis and Punctuation</li>
     * </ul>
     * //TODO: If array size is 0 it is new paragraph. WARN: multiple empty in a row = 1 paragraph
     * <p>Print and check the quotes. They are all currently stored in punctuation.
     *     To access them, call rhetAnalysis.getPunctuation</p>
     * @param args main functions args array.
     */
    public static void runApp(String[] args){

        //Read the File
        List<List<String>> fileLines = new LinkedList<List<String>>();
        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            fileLines = BankLoader.readUntaggedData(scanner);

            // tag the data
        } catch (IOException e){
            e.printStackTrace();
        }
        //Tag The Lines
        Tagger tagger = new Viterbi();
        List<List<TaggedWord>> taggedSentences = tagger.tag(fileLines);
//        System.out.println(taggedSentences);
        RhetAnalysis rhetAnalysis = new RhetAnalysis();

        /**
         * boolean for paragraph counting. If there are more than one line breaks in a row,
         this boolean is switched to false to avoid over-counting the number of paragraphs
         */
            boolean notIncremented = true;
            for (List<TaggedWord> sentence : taggedSentences){
                if (sentence.isEmpty() && notIncremented){
                    rhetAnalysis.incrementParagraph();
                    notIncremented = false;
                }
                else{
                    notIncremented = true;
                }
                for (TaggedWord taggedWord : sentence){
                    rhetAnalysis.add(taggedWord);
                }
            }
        rhetAnalysis.calculateAverages();
        System.out.println(rhetAnalysis.toString());
        System.out.println(rhetAnalysis.getPunctuation().toString());

        Author userAuthor = new Author("USER", rhetAnalysis);
        System.out.println(userAuthor.printVector());

//        Map<String,Double> scores = VectorScoring.compareStats(userAuthor.getVectorStat());
//        System.out.println(scores);
//        Authors.writeAuthor(janeA);
    }

    public static void main(String[] args) {
        //TODO: REMOVE
        args = new String[] {"/Users/GleasonK/IdeaProjects/RhetID/Texts/kgzr_texts/_400_plato/laws_republic_apology.txt"};
        //TODO: ENDREMOVE


//        if (args.length != 1){
//            System.out.println("Usage: java RhetIdApp <txt file>");
//            System.exit(1);
//        }
//        String s = "I unwillingly go to the park. Kevin.\nHear me roar!\n\nI am lovely paragraph two.";
        runApp(args);
//        runWebApp(s);
    }
}
