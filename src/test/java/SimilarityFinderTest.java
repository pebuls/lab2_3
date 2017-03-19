import edu.iis.mto.similarity.StubSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SimilarityFinderTest {
    StubSequenceSearcher mockSequenceSearcher = new StubSequenceSearcher();
    private SimilarityFinder similarityFinder = new SimilarityFinder(mockSequenceSearcher);
    @Test
    public void sameSequencesTest(){
        int[] seq1 = {1,2,3};
        int[] seq2 = {1,2,3};
        double actual = similarityFinder.calculateJackardSimilarity(seq1,seq2);
        Assert.assertThat(actual, is(equalTo(1.0)));
    }
    @Test
    public void emptySequencesTest(){
        int[] seq1 = {};
        int[] seq2 = {};
        double actual = similarityFinder.calculateJackardSimilarity(seq1,seq2);
        Assert.assertThat(actual, is(equalTo(1.0)));
    }
    @Test
    public void emptyFirstSequence(){
        int[] seq1 = {};
        int[] seq2 = {4,3,6};
        double actual = similarityFinder.calculateJackardSimilarity(seq1,seq2);
        Assert.assertThat(actual, is(equalTo(0.0)));
    }
    @Test (expected = IllegalArgumentException.class)
    public void emptySecondSequence(){
        int[] seq1 = {1,2,3};
        int[] seq2 = {};
        double actual = similarityFinder.calculateJackardSimilarity(seq1,seq2);
    }
    @Test
    public void secondIsHalfFirstSequence(){
        int[] seq1 = {1,2,3,4,5,6,7,8,9,10};
        int[] seq2 = {1,2,3,4,5};
        double actual = similarityFinder.calculateJackardSimilarity(seq1,seq2);
        Assert.assertThat(actual, is(equalTo(0.5)));
    }
    @Test
    public void symmetryTest(){
        int[] seq1 = {1,2,3,4,5,6,7,8,9};
        int[] seq2 = {1,2,4,5};
        double actual = similarityFinder.calculateJackardSimilarity(seq1,seq2);
        double actual2 = similarityFinder.calculateJackardSimilarity(seq2,seq1);
        Assert.assertThat(actual, is(equalTo(actual2)));
    }
    @Test
    public void numberOfSearchCallsTest(){
        int[] seq1 = {1,2,3};
        int[] seq2 = {1,2,3};
        double actual = similarityFinder.calculateJackardSimilarity(seq1,seq2);
        Assert.assertThat(mockSequenceSearcher.getCallCounter(),is(equalTo(3)));
    }
    @Test
    public void parameterTest(){
        int[] seq1 = {1,2,3,4,5,6,7,8,9,10};
        int[] seq2 = {1,2,3,4};
        double actual = similarityFinder.calculateJackardSimilarity(seq1,seq2);
        Assert.assertThat(mockSequenceSearcher.getKey(),is(equalTo(10)));
        Assert.assertThat(mockSequenceSearcher.getSeq(),is(equalTo(seq2)));
    }


}
