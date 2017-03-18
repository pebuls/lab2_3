package edu.iis.mto.similarity;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Piotrek on 18.03.2017.
 */
public class SimilarityFinderTest {

    private MockSequnceSearcher mockSequnceSearcher = new MockSequnceSearcher();
    private SimilarityFinder similarityFinder = new SimilarityFinder(mockSequnceSearcher);

    @Test
    public void sameArraysTest(){
        int[] seq1 = {10, 20, 30};
        int[] seq2 = {10, 20, 30};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(result, is(equalTo(1.0)));
    }

    @Test
    public void differentArraysTest(){
        int[] seq1 = {10, 20, 30};
        int[] seq2 = {1, 2, 3};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(result, is(equalTo(0.0)));
    }

    @Test(expected = NullPointerException.class)
    public void nullArraysTest(){
        int[] seq1 = null;
        int[] seq2 = null;

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
    }

    @Test
    public void arraysWithSameFragmentAndDifferentLength(){
        int[] seq1 = {10, 20, 30};
        int[] seq2 = {10, 20, 30, 40};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(result, is(equalTo(0.75)));
    }

    @Test
    public void emptyArraysTest(){
        int[] seq1 = {};
        int[] seq2 = {};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(result, is(equalTo(1.0)));
    }

    @Test
    public void sameLengthArraysWithOneDifferentElement(){
        int[] seq1 = {10, 20, 30};
        int[] seq2 = {10, 20, 25};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(result, is(equalTo(0.5)));
    }

    @Test
    public void sameLengthArraysWithTwoDifferentElement(){
        int[] seq1 = {10, 20, 30};
        int[] seq2 = {10, 15, 25};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(result, is(equalTo(0.2)));
    }

    @Test(expected = OutOfMemoryError.class)
    public void arraysWithMaxInt(){
        int[] seq1 = new int[Integer.MAX_VALUE];
        int[] seq2 = new int[Integer.MAX_VALUE];

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
    }

    @Test
    public void sameLengthArraysWithTwoSameElementsOnDifferentPositions(){
        int[] seq1 = {10, 20, 30};
        int[] seq2 = {20, 15, 10};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(result, is(equalTo(0.5)));
    }

    @Test
    public void differentArraysNotSameLegth(){
        int[] seq1 = {10, 20, 30};
        int[] seq2 = {50, 15, 60, 65};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(result, is(equalTo(0.0)));
    }

    @Test
    public void callsCounterCheck(){
        int[] seq1 = {10, 20};
        int[] seq2 = {50, 60};

        similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(mockSequnceSearcher.callsCounter, is(equalTo(2)));
    }
}