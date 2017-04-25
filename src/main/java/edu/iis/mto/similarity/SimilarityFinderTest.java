package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

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

    private static Integer[] intsToArray(int[] array) {
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    @Test
    public void jackardSimilarityWithSameArrays() throws Exception {
        final int[] intA = new int[]{1, 5, -3, 12, 69, 8};
        int[] intB = new int[intA.length];
        System.arraycopy(intA, 0, intB, 0, intA.length);
        double actual = finder.calculateJackardSimilarity(intA, intB);
        assertThat(actual, is(1.0d));
        for(MockSequenceSearcher.Call call : mockSequenceSearcher.calls) {
            assertThat(call.param, isIn(intsToArray(intA)));
            assertThat(call.sequence, isOneOf(intA, intB));
        }
    }


    @Test
    public void jackardSimilarityWithDifferentArrays() throws Exception {
        int[] intA = new int[]{2, 7, -5, 13, 69, 16};
        int[] intB = new int[]{0, -23, 11, 13, 123};
        double actual = finder.calculateJackardSimilarity(intA, intB);
        assertThat(actual, is(0.0d));
        for(MockSequenceSearcher.Call call : mockSequenceSearcher.calls) {
            assertThat(call.param, isIn(intsToArray(intA)));
            assertThat(call.sequence, isOneOf(intB));
        }
}
}