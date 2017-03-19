package lab2_3;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import edu.iis.mto.similarity.SequenceMockFinder;
import edu.iis.mto.similarity.SimilarityFinder;



public class SimilarityFinderTests {
	SequenceMockFinder sMockFinder = new SequenceMockFinder();
	SimilarityFinder sFinder = new SimilarityFinder(sMockFinder);

	@Test
	public void testEmpty() {
		int[] seq1 = new int[0], seq2 = new int[0];
		double result = sFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(1.0)));		
	}
	
	@Test
	public void testSame() {
		int[] seq1 = {4,7,3}, seq2 = {7,3,4};
		double result = sFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(1.0)));
	}
	
	@Test
	public void testDifferentSameLength() {
		int[] seq1 = {4,7,3}, seq2 = {7,3,8};
		double result = sFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(0.5)));
	}
	
	@Test
	public void testDifferentDifferentLength() {
		int[] seq1 = {4,7,3}, seq2 = {9,1,8,5};
		double result = sFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(0.0)));
	}
	
	@Test
	public void testSimilarDifferentLength() {
		int[] seq1 = {4,7,3}, seq2 = {7,3,4,5};
		double result = sFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(0.75)));
	}
	
	@Test
	public void testOneElementSameDifferentLength() {
		int[] seq1 = {4,7}, seq2 = {7,1,2,5};
		double result = sFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(0.2)));
	}
	
	@Test (expected = NullPointerException.class)
	public void testNulls() {
		int[] seq1 = null, seq2 = null;
		double result = sFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(1.0)));
	}
	
	@Test
	public void testAlmostSameSameLength() {
		int[] seq1 = {4,7,3}, seq2 = {7,4,2};
		double result = sFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(0.5)));
	}
	
	@Test
	public void testNumOfCalls() {
		int[] seq1 = {4,7,3}, seq2 = {7,4,2};
		double result = sFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(sMockFinder.getCallCount(), is(equalTo(3)));
	}
	
	@Test
	public void testParams() {
		int[] seq1 = {4,7,3}, seq2 = {7,4,2};
		double result = sFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(sMockFinder.getKey(), is(equalTo(3)));
		assertThat(sMockFinder.getSeq(), is(equalTo(seq2)));
	}

}