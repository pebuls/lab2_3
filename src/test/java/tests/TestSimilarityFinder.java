package tests;


import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.DummySequenceSearcher;
import org.junit.Test;
import edu.iis.mto.similarity.SimilarityFinder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jankowskirobert
 */
public class TestSimilarityFinder {
    
    @Test
    public void testCalculateJackardSimilarityEmptySqeuence(){
        SequenceSearcher searcher = new DummySequenceSearcher();
        SimilarityFinder finder = new SimilarityFinder(searcher);        
        final int[] emptySeq = new int[] {};
        double result = finder.calculateJackardSimilarity(emptySeq, emptySeq);
        assertThat(result, is(1.0d));
    }
    
}
