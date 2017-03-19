package edu.iis.mto.similarity;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Konrad Gos on 18.03.2017.
 */
public class SimilarityFinderTest {

    @Test
    public void checkTwoEmptySequence() {
        MockupSequenceSearcher mockupSequenceSearcher = new MockupSequenceSearcher();
        SimilarityFinder similarityFinder = new SimilarityFinder(mockupSequenceSearcher);

        int[] firstSeqeunce = new int[0];
        int[] secondSeqeunce = new int[0];

        double similarityResult = similarityFinder.calculateJackardSimilarity(firstSeqeunce,secondSeqeunce);

        assertThat(similarityResult, is(1.0));
    }

}