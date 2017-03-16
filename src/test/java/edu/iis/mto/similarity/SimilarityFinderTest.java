package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
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

    private static Integer[] intsToArray(int[] array) {
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    @Test
    public void testCalculateJackardSimilarity_SameArrays() throws Exception {
        int[] ints1 = new int[]{1, 5, -3, 12, 69, 8};
        int[] ints2 = new int[ints1.length];
        System.arraycopy(ints1, 0, ints2, 0, ints1.length);

        double actual = finder.calculateJackardSimilarity(ints1, ints2);

        assertThat(actual, is(1.0d));

        for(MockSequenceSeeker.Call call : mockSequenceSeeker.calls) {
            assertThat(call.param, isIn(intsToArray(ints1)));
            assertThat(call.sequence, is(ints2));
        }

    }

    @Test
    public void testCalculateJackardSimilarity_FullyDifferentArrays() throws Exception {
        int[] ints1 = new int[]{1, 5, -3, 12, 8};
        int[] ints2 = new int[]{0, -5, 9, 13, 169};

        double actual = finder.calculateJackardSimilarity(ints1, ints2);

        assertThat(actual, is(0.0d));

        for(MockSequenceSeeker.Call call : mockSequenceSeeker.calls) {
            assertThat(call.param, isIn(intsToArray(ints1)));
            assertThat(call.sequence, is(ints2));
        }
    }

    @Test
    public void testCalculateJackardSimilarity_PartiallySame() throws Exception {
        int[] ints1 = new int[]{1, 5, 10};
        int[] ints2 = new int[]{0, 1, 8};

        double actual = finder.calculateJackardSimilarity(ints1, ints2);

        assertThat(actual, is(0.2d));

        for(MockSequenceSeeker.Call call : mockSequenceSeeker.calls) {
            assertThat(call.param, isIn(intsToArray(ints1)));
            assertThat(call.sequence, is(ints2));
        }
    }

    @Test
    public void testCalculateJackardSimilarity_PartiallySame_DifferentLength() throws Exception {
        int[] ints1 = new int[]{2, 9, 13, 69};
        int[] ints2 = new int[]{13};

        double actual = finder.calculateJackardSimilarity(ints1, ints2);

        assertThat(actual, is(0.25d));

        for(MockSequenceSeeker.Call call : mockSequenceSeeker.calls) {
            assertThat(call.param, isIn(intsToArray(ints1)));
            assertThat(call.sequence, is(ints2));
        }
    }
}