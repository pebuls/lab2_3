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

    @Before
    public void init() {
        finder = new SimilarityFinder(new MockSequenceSearcher());
    }

    @Test
    public void returnOneWhenSequencesAreEmpty() {
        int[] seq1 = {};
        int[] seq2 = {};
        final double EXPECTED = 1.0;

        Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(EXPECTED));
    }
}
