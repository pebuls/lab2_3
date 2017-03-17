package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by Sasho on 2017-03-17.
 */
public class SimilarityFinderTest {

    private SimilarityFinder similarityFinder;
    private Searcher searcher;

    @Before
    public void setUp() throws Exception {
        searcher = new Searcher();
        similarityFinder = new SimilarityFinder(searcher);
    }

    @Test
    public void test_emptyArrays() throws Exception {
        int[] tab1 = new int[0];
        int[] tab2 = new int[0];

        double actual = similarityFinder.calculateJackardSimilarity(tab1, tab2);

        assertThat(actual, is(1.0d));
    }
    @Test
    public void test_sameArrays() throws Exception {
        int[] tab1 = new int[] {1,2,3};
        int[] tab2 = new int[] {3,2,1};

        double actual = similarityFinder.calculateJackardSimilarity(tab1, tab2);

        assertThat(actual, is(1.0d));
    }

    @Test
    public void test_differentArrays() throws Exception {
        int[] tab1 = new int[] {1,2,3};
        int[] tab2 = new int[] {4,6,5};

        double actual = similarityFinder.calculateJackardSimilarity(tab1, tab2);

        assertThat(actual, is(0d));
    }


}