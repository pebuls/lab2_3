package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.emptyIterable;

public class SimilarityFinderTest {

    private MockSequenceSearcher mockSequenceSearcher;
    private SimilarityFinder finder;

    @Before
    public void setUp() throws Exception {
        mockSequenceSearcher = new MockSequenceSearcher();
        finder = new SimilarityFinder(mockSequenceSearcher);
    }

    @Test
    public void jackardSimilarityWithEmptyArrays() throws Exception {

        double actual = finder.calculateJackardSimilarity(new int[0], new int[0]);

        assertThat(actual, is(1.d));
        assertThat(mockSequenceSearcher.calls, emptyIterable());
    }
}