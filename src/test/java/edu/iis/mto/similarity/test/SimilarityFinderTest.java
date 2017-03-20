package edu.iis.mto.similarity.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import edu.iis.mto.similarity.SimilarityFinder;

public class SimilarityFinderTest {
	
	//SequenceMockFinder sMockFinder = new SequenceMockFinder();
	//SimilarityFinder sFinder = new SimilarityFinder(sMockFinder);

	@Test
	public void testCalculateJackardSimilarity() {
		int[] seq1 = {};
		int[] seq2 = {};
		Double result = SimilarityFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(1.0, is(equalTo(result)));
	}
	@Ignore
	@Test
	 	public void testSame() throws NullPointerException {
	 		int[] seq1 = {4,7,3};
			int[] seq2 = {7,3,4};
	 		double result = SimilarityFinder.calculateJackardSimilarity(seq1, seq2);
			assertThat(result, is(equalTo(1.0)));
	 	}

}
