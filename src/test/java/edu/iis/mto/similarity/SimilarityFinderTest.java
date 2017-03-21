package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.isOneOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by RFran on 21.03.2017.
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
        assertThat(result,is(1.0));

        Integer[] convertedSeq1 = convertIntArrayToIntegerArray(seq1);

        for(MockSequenceSeeker.SearchMethodCall call : mockSequenceSeeker.calls){

            assertThat(call.getSearchedKey(),isIn(convertedSeq1));
            assertThat(call.getSearchedSequence(),isOneOf(seq1,seq2));

        }
    }

    @Test public void calculateJackardSimilarity_emptySequences(){
        int[] seq1 = {};
        int[] seq2 = seq1;
        double result = finder.calculateJackardSimilarity(seq1,seq2);
        assertThat(result,is(1.0));
        assertThat(mockSequenceSeeker.calls, emptyIterable());

    }

    @Test public void calculateJackardSimilarity_partiallySameSequences_sameLength(){
        int[] seq1 = {1,2,3,4};
        int[] seq2 = {2,3,4,5};
        double result = finder.calculateJackardSimilarity(seq1,seq2);
        assertThat(result,is(0.6));
        Integer[] convertedSeq1 = convertIntArrayToIntegerArray(seq1);

        for(MockSequenceSeeker.SearchMethodCall call : mockSequenceSeeker.calls){

            assertThat(call.getSearchedKey(),isIn(convertedSeq1));
            assertThat(call.getSearchedSequence(),isOneOf(seq1,seq2));

        }
    }

    @Test public void calculateJackardSimilarity_partiallySameSequences_differentLength(){
        int[] seq1 = {1,2,3,4};
        int[] seq2 = {2,3,4,5,6};
        double result = finder.calculateJackardSimilarity(seq1,seq2);
        assertThat(result,is(0.5));
        Integer[] convertedSeq1 = convertIntArrayToIntegerArray(seq1);

        for(MockSequenceSeeker.SearchMethodCall call : mockSequenceSeeker.calls){

            assertThat(call.getSearchedKey(),isIn(convertedSeq1));
            assertThat(call.getSearchedSequence(),isOneOf(seq1,seq2));

        }
    }
}
