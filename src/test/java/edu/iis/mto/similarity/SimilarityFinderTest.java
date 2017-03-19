package edu.iis.mto.similarity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.isOneOf;

/**
 * Created by grusz on 19.03.2017.
 */
public class SimilarityFinderTest {

    private MockSequenceSeeker mockSequenceSeeker;
    private SimilarityFinder finder;

    private Integer[] convertIntArrayToIntegerArray(int[] intArray){
        Integer[] objectArray = new Integer[intArray.length];

        for(int ctr = 0; ctr < intArray.length; ctr++) {
            objectArray[ctr] = intArray[ctr];
        }
        return objectArray;
    }

    @Before public void setUp() throws Exception {
        mockSequenceSeeker = new MockSequenceSeeker();
        finder = new SimilarityFinder(mockSequenceSeeker);
    }

    @Test public void calculateJackardSimilarity_sameSequences(){
        int[] seq1 = {1,2,3,4,5};
        int[] seq2 = seq1;
        double result = finder.calculateJackardSimilarity(seq1,seq2);

        Integer[] convertedSeq1 = convertIntArrayToIntegerArray(seq1);

        for(MockSequenceSeeker.SearchMethodCall call : mockSequenceSeeker.calls){

            Assert.assertThat(call.getSearchedKey(),isIn(convertedSeq1));
            Assert.assertThat(call.getSearchedSequence(),isOneOf(seq1,seq2));

        }
    }
}
