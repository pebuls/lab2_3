import edu.iis.mto.similarity.MockSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Piotr on 18.03.2017.
 */
public class SimilarityFinderTest {

    private MockSequenceSearcher mockSequenceSearcher = new MockSequenceSearcher();
    private SimilarityFinder similarityFinder = new SimilarityFinder(mockSequenceSearcher);

    @Test
    public void sameArraysSimilarity() {
        final double EXPECTED_RESULT = 1.0;
        final int[] ARR1 = {1, 2, 3, 4};
        final int[] ARR2 = {1, 2, 3, 4};

        double result = similarityFinder.calculateJackardSimilarity(ARR1, ARR2);

        assertThat(result, is(EXPECTED_RESULT));
    }

    @Test
    public void sameLengthsTotallyDifferentElementsArraysSimilarity() {
        final double EXPECTED_RESULT = 0.0;
        final int[] ARR1 = {1, 2, 3, 4};
        final int[] ARR2 = {5, 6, 7, 8};

        double result = similarityFinder.calculateJackardSimilarity(ARR1, ARR2);

        assertThat(result, is(EXPECTED_RESULT));
    }
}
