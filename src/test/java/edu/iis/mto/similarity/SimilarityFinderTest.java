package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class SimilarityFinderTest {
    private SimilarityFinder similarityFinder;
    private MockSequenceSearcher mockSequenceSearcher;
    @Before
    public void setUp() throws Exception {
        mockSequenceSearcher = new MockSequenceSearcher();
        similarityFinder = new SimilarityFinder(mockSequenceSearcher);
    }
    @Test
    public void testCalculateWithEmptySize() throws Exception {
        int[] array1 = new int[]{};
        int[] array2 = new int[]{};
        assertThat(similarityFinder.calculateJackardSimilarity(array1, array2), is(1.0d));
    }
    @Test
    public void testCalculateWithDifferentArrays() throws Exception {
        int[] array1 = new int[] {1,2};
        int[] array2 = new int[] {3};
        assertThat(similarityFinder.calculateJackardSimilarity(array1, array2), is(0d));
    }
    @Test
    public void testCalculateWithTheSameArrays() throws Exception {
        int[] array1 = new int[] {1,3,6};
        int[] array2 = new int[] {1,3,6};
        assertThat(similarityFinder.calculateJackardSimilarity(array1, array2), is(1.0d));
    }
    @Test
    public void testCount() throws Exception {
        int[] array1 = new int[]{1, 8, 9};
        int[] array2 = new int[]{3, 4, 6};
        similarityFinder.calculateJackardSimilarity(array1, array2);
        assertThat(mockSequenceSearcher.count, is(3));
    }
}