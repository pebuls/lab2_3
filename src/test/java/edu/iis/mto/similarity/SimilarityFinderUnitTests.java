package edu.iis.mto.similarity;


import static org.junit.Assert.*;


import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class SimilarityFinderUnitTests {

	private SimilarityFinder similarityFinder;
    private Searcher searcher;
    
    @Before
    public void setUp() throws Exception {
        searcher = new Searcher();
        similarityFinder = new SimilarityFinder(searcher);
    }
    
    @Test
    public void testEmptyArrays() throws Exception {
        int[] tab1 = new int[0];
        int[] tab2 = new int[0];

        double actual = similarityFinder.calculateJackardSimilarity(tab1, tab2);

       assertThat(actual, is(1.0d));
    }
    
    @Test
    public void testDifferentArrays() throws Exception {
        int[] tab1 = new int[] {1,2,3};
        int[] tab2 = new int[] {4,6,5};

        double actual = similarityFinder.calculateJackardSimilarity(tab1, tab2);

        assertThat(actual, is(0d));
    }

}
