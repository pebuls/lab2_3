package edu.iis.mto.similarity;


import static org.junit.Assert.*;

import org.hamcrest.generator.qdox.Searcher;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class SimilarityFinderUnitTests {

	private SimilarityFinder similarityFinder;
    private Searcher searcher;
    
    
    @Test
    public void test_emptyArrays() throws Exception {
        int[] tab1 = new int[0];
        int[] tab2 = new int[0];

        double actual = similarityFinder.calculateJackardSimilarity(tab1, tab2);

       assertThat(actual, is(1.0d));
    }

}
