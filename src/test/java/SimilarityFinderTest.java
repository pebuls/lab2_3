import edu.iis.mto.similarity.MockSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SimilarityFinderTest {
    private SimilarityFinder similarityFinder = new SimilarityFinder(new MockSequenceSearcher());
    @Test
    public void sameSequencesTest(){
        int seq1[] = {1,2,3};
        int seq2[] = {1,2,3};
        double actual = similarityFinder.calculateJackardSimilarity(seq1,seq2);
        Assert.assertThat(actual, is(equalTo(1.0)));
    }
    @Test
    public void emptySequencesTest(){
        int seq1[] = {};
        int seq2[] = {};
        double actual = similarityFinder.calculateJackardSimilarity(seq1,seq2);
        Assert.assertThat(actual, is(equalTo(1.0)));
    }
    @Test
    public void emptyFirstSequence(){
        int seq1[] = {};
        int seq2[] = {4,3,6};
        double actual = similarityFinder.calculateJackardSimilarity(seq1,seq2);
        Assert.assertThat(actual, is(equalTo(0.0)));
    }
    @Test (expected = IllegalArgumentException.class)
    public void emptySecondSequence(){
        int seq1[] = {1,2,3};
        int seq2[] = {};
        double actual = similarityFinder.calculateJackardSimilarity(seq1,seq2);
    }
    @Test
    public void secondIsHalfFirstSequence(){
        int seq1[] = {1,2,3,4,5,6,7,8,9,10};
        int seq2[] = {1,2,3,4,5};
        double actual = similarityFinder.calculateJackardSimilarity(seq1,seq2);
        Assert.assertThat(actual, is(equalTo(0.5)));
        System.out.print(actual);
    }


}
