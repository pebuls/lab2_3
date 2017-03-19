package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Konrad Gos on 18.03.2017.
 */
public class SimilarityFinderTest {

    private MockupSequenceSearcher mockupSequenceSearcher;
    private SimilarityFinder similarityFinder;

    @Before
    public void setUp() throws Exception {
        mockupSequenceSearcher = new MockupSequenceSearcher();
        similarityFinder = new SimilarityFinder(mockupSequenceSearcher);
    }

    @Test
    public void checkTwoEmptySequences() {
        int[] firstSeqeunce = new int[0];
        int[] secondSeqeunce = new int[0];

        double similarityResult = similarityFinder.calculateJackardSimilarity(firstSeqeunce,secondSeqeunce);

        assertThat(similarityResult, is(1.0));
    }

    @Test
    public void checkTwoSameSequences() {
        int[] firstSeqeunce = new int[] {1, 2, 3};
        int[] secondSeqeunce = new int[] {1, 2, 3};

        double similarityResult = similarityFinder.calculateJackardSimilarity(firstSeqeunce,secondSeqeunce);

        assertThat(similarityResult, is(1.0));
    }

}