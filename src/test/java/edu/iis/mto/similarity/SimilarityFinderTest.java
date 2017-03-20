package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Klaudia on 20.03.2017.
 */
public class SimilarityFinderTest {
    SimilarityFinder similarityFinder;
    private MockSequenceSearcher dummySequenceSearcher;

    @Before
    public void setUp() {
        dummySequenceSearcher = createDummySequenceSearcher();
        similarityFinder = new SimilarityFinder(dummySequenceSearcher);

    }

    private MockSequenceSearcher createDummySequenceSearcher() {
        return new MockSequenceSearcher();
    }

    @Test
    public void testCalculateJackardSimilarityAnotherSizeSeq() throws Exception {
        int[] seq1 = new int[]{1, 2, 3, 4, 5};
        int[] seq2 = new int[]{1, 2, 3};
        double expected = (double) 3 / 5;

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

        assertThat(result, is(expected));
    }

    @Test
    public void testCalculateJackardEmptySeq() throws Exception {
        int[] seq1 = new int[]{};
        int[] seq2 = new int[]{};
        double expected = (double) 1;

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

        assertThat(result, is(expected));
    }

    @Test
    public void testCalculateJackardTheSameContentSeq() {
        int[] seq = new int[]{1, 2, 3};

        double expected = (double) 1;

        double result = similarityFinder.calculateJackardSimilarity(seq, seq);

        assertThat(result, is(expected));
    }

    @Test
    public void testCalculateJackardTheSameSeqLenAnotherContents() {
        int[] seq = new int[]{1, 2, 3};
        int[] seq1 = new int[]{1, 2, 5};

        double expected = (double) 2 / 4;

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq);

        assertThat(result, is(expected));
    }

    @Test
    public void testCalculateJackardSearchCallNumber() {
        int[] seq = new int[]{1, 2, 3};
        int[] seq1 = new int[]{1, 2, 5, 4};

        int expected = 4;

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq);

        assertThat(dummySequenceSearcher.getCallCounter(), is(expected));

    }


}