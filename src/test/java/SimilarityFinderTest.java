import edu.iis.mto.similarity.MockSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SimilarityFinderTest {
    @Test
    public void sameSequencesTest(){
        SimilarityFinder similarityFinder = new SimilarityFinder(new MockSequenceSearcher());
        int seq1[] = {1,2,3};
        int seq2[] = {1,2,3};
        double actual = similarityFinder.calculateJackardSimilarity(seq1,seq2);
        Assert.assertThat(actual, is(equalTo(1.0)));
    }
}
