package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimilarityFinderTest {

    private MockSequenceSeeker mockSequenceSeeker;
    private SimilarityFinder finder;

    @Before
    public void setUp() throws Exception {
        mockSequenceSeeker = new MockSequenceSeeker();
        finder = new SimilarityFinder(mockSequenceSeeker);
    }

    @Test
    public void testCalculateJackardSimilarity_EmptyArrays() throws Exception {

        double actual = finder.calculateJackardSimilarity(new int[0], new int[0]);

        assertThat(actual, is(1.d));
        assertThat(mockSequenceSeeker.calls, emptyIterable());
    }
}