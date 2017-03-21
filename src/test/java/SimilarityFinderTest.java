import edu.iis.mto.similarity.SimilarityFinder;
import mockClasses.MockSequenceSearcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Wojciech Szczepaniak on 20.03.2017.
 */
public class SimilarityFinderTest {

    private SimilarityFinder finder;
    private MockSequenceSearcher searcher;

    @Before
    public void init() {
        searcher = new MockSequenceSearcher();
        finder = new SimilarityFinder(searcher);
    }

    @Test
    public void returnOneWhenSequencesAreEmpty() {
        int[] seq1 = {};
        int[] seq2 = {};
        final double EXPECTED = 1.0;
        final int EXPECTED_CALLS = 0;

        Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS));
    }

    @Test
    public void returnZeroWhenOneSequenceIsEmpty() {
        int[] seq1 = {1};
        int[] seq2 = {};
        final double EXPECTED = 0.0;
        final int EXPECTED_CALLS_1 = 1;
        final int EXPECTED_CALLS_2 = 0;

        Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_1));
        Assert.assertThat(finder.calculateJackardSimilarity(seq2, seq1), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_2));
    }

    @Test
    public void returnOneWhenOneElementSequencesAreTheSame() {
        int[] seq1 = {1};
        int[] seq2 = {1};
        final double EXPECTED = 1.0;
        final int EXPECTED_CALLS_1 = 1;
        final int EXPECTED_CALLS_2 = 1;

        Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_1));
        Assert.assertThat(finder.calculateJackardSimilarity(seq2, seq1), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_2));
    }

    @Test
    public void returnZeroWhenOneElementSequencesAreDifferent() {
        int[] seq1 = {1};
        int[] seq2 = {2};
        final double EXPECTED = 0.0;
        final int EXPECTED_CALLS_1 = 1;
        final int EXPECTED_CALLS_2 = 1;

        Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_1));
        Assert.assertThat(finder.calculateJackardSimilarity(seq2, seq1), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_2));
    }

    @Test
    public void returnOneWhenMultipleElementsSequencesWithTheSameSizeHaveTheSameElements() {
        int[] seq1 = {1, 2};
        int[] seq2 = {2, 1};
        final double EXPECTED = 1.0;
        final int EXPECTED_CALLS_1 = 2;
        final int EXPECTED_CALLS_2 = 2;

        Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_1));
        Assert.assertThat(finder.calculateJackardSimilarity(seq2, seq1), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_2));
    }

    @Test
    public void multipleElementsSequencesWithTheSameSizeHaveNotAllTheSameElements() {
        int[] seq1 = {1, 3};
        int[] seq2 = {2, 1};
        final double EXPECTED = 1.0/3.0;
        final int EXPECTED_CALLS_1 = 2;
        final int EXPECTED_CALLS_2 = 2;

        Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_1));
        Assert.assertThat(finder.calculateJackardSimilarity(seq2, seq1), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_2));
    }

    @Test
    public void returnZeroWhenMultipleElementsSequencesWithTheSameSizeHaveDifferentElements() {
        int[] seq1 = {1, 2};
        int[] seq2 = {3, 4};
        final double EXPECTED = 0.0;
        final int EXPECTED_CALLS_1 = 2;
        final int EXPECTED_CALLS_2 = 2;

        Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_1));
        Assert.assertThat(finder.calculateJackardSimilarity(seq2, seq1), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_2));
    }

    @Test
    public void firstSequenceIsPartOfSecond() {
        int[] seq1 = {1, 2};
        int[] seq2 = {2, 1, 3};
        final double EXPECTED = 2.0/3.0;
        final int EXPECTED_CALLS_1 = 2;
        final int EXPECTED_CALLS_2 = 3;

        Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_1));
        Assert.assertThat(finder.calculateJackardSimilarity(seq2, seq1), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_2));
    }

    @Test
    public void firstSequenceHaveElementNotExistInSecondBiggerSequence() {
        int[] seq1 = {1, 4};
        int[] seq2 = {2, 1, 3};
        final double EXPECTED = 1.0/4.0;
        final int EXPECTED_CALLS_1 = 2;
        final int EXPECTED_CALLS_2 = 3;

        Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_1));
        Assert.assertThat(finder.calculateJackardSimilarity(seq2, seq1), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_2));
    }

    @Test
    public void firstSequenceHaveDifferentElementsThanSecondBiggerSequence() {
        int[] seq1 = {5, 4};
        int[] seq2 = {2, 1, 3};
        final double EXPECTED = 0.0;
        final int EXPECTED_CALLS_1 = 2;
        final int EXPECTED_CALLS_2 = 3;

        Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_1));
        Assert.assertThat(finder.calculateJackardSimilarity(seq2, seq1), is(EXPECTED));
        Assert.assertThat(searcher.getCall(), is(EXPECTED_CALLS_2));
    }
}
