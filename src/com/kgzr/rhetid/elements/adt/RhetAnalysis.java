package com.kgzr.rhetid.elements.adt;

import com.kgzr.rhetid.pos.adt.TaggedWord;
import com.kgzr.rhetid.pos.util.PosTags;

/**
 * Created by Kevin and Zach on 12/1/14.
 * Digests one word at a time and calculates the frequency of parts of speech.
 */
//TODO: Passive vs Active voice.
//Passive:
// Was/VBD, killed/VBN --> metric: = consequtive occurance
// is/VBZ, killing/VBG
// failed/VBD
//
public class RhetAnalysis {
    private Punctuation punctuation;

    private double  nnPerSent = 0d;
    private double  pnPerSent = 0d;
    private double  ppPerSent = 0d;
    private double  vbPerSent = 0d;
    private double adjPerSent = 0d;
    private double advPerSent = 0d;


    public double avgSentLength = 0d;
    public double avgParaLength = 0d;

    public int      nouns = 0;
    public int  propNouns = 0;
    public int   proNouns = 0;
    public int      verbs = 0;
    public int adjectives = 0;
    public int    adverbs = 0;

    public int sentences  = 0;
    public int     words  = 0;
    public int paragraphs = 1; //Always at least 1 paragraph

    public RhetAnalysis(){
        this.punctuation = new Punctuation();
    }

    /**
     * Consume a word.
     * Check if the word is a punctuation or a word based off its tag.
     * Increment sentences if punctuation, else increment word.
     * Does all punctuation calculations as well.
     *
     * @param word
     */
    public void add(TaggedWord word){
        String tag = word.getTag();

        if (PosTags.PUNCTUATION_ALL.contains(tag)) {
            this.punctuation.add(word.getWord());
            if (PosTags.PUNCTUATION_END.contains(tag))
                sentences++;
        }
        else {
            words++;
        }

        if (PosTags.ADVERB.contains(tag)) adverbs++;

        else if (PosTags.ADJECTIVE.contains(tag)) adjectives++;

        else if (PosTags.NOUN.contains(tag)) nouns++;

        else if (PosTags.PROPER_NOUN.contains(tag)) propNouns++;

        else if (PosTags.PRONOUN.contains(tag)) proNouns++;

        else if (PosTags.VERB.contains(tag)) verbs++;

        else {
            //Unconsumed tagged words.
//            System.out.println("Unconsumed: " + word.getWord() + " " + word.getTag());
        }
    }

    /*
    count number of paragraphs in a text.
     */
    public void incrementParagraph(){
        paragraphs++;
    }

    public void calculateAverages(){
        double sents = (double) sentences;

        this.punctuation.calculateAverages((double) this.words);

        nnPerSent = nouns/sents;
        pnPerSent = propNouns/sents;
        ppPerSent = proNouns/sents;
        vbPerSent = verbs/sents;
        adjPerSent = adjectives/sents;
        advPerSent = adverbs/sents;

        avgSentLength = words/sents;
        avgParaLength = sents/paragraphs;
    }

    public Punctuation getPunctuation() { return punctuation; }

    public double getNnPerSent() { return nnPerSent; }

    public double getPnPerSent() { return pnPerSent; }

    public double getPpPerSent() { return ppPerSent; }

    public double getVbPerSent() { return vbPerSent; }

    public double getAdjPerSent() { return adjPerSent; }

    public double getAdvPerSent() { return advPerSent; }

    public double getAvgSentLength() { return avgSentLength; }

    public double getAvgParaLength() { return avgParaLength; }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("NN/S: | " + this.nnPerSent + "|\n");
        sb.append("PN/S: | " + this.pnPerSent + "|\n");
        sb.append("PP/S: | " + this.ppPerSent + "|\n");
        sb.append("VB/S: | " + this.vbPerSent + "|\n");
        sb.append("JJ/S: | " + this.adjPerSent +"|\n");
        sb.append("RB/S: | " + this.advPerSent +"|\n");
        sb.append("Words: | " + this.words + "|\n");
        sb.append("Sentences: | " + this.sentences + "|\n");
        sb.append("AvgSent: | " + this.avgSentLength + "|\n");
        sb.append("Paragraphs: | " + this.paragraphs + "|\n");
        sb.append("Avg_Sent/P: | " + this.avgParaLength + "|\n");

        return sb.toString();
    }

}
