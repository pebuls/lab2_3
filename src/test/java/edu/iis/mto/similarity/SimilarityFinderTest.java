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
    public void emptyArraysTest(){
        int[] seq1 = null;
        int[] seq2 = null;

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
    }
}