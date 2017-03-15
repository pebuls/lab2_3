package edu.iis.mto.similarity.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import edu.iis.mto.similarity.SimilarityFinder;

public class SimilarityFinderTest {

	@Test
	public void testCalculateJackardSimilarity() {
		int[] seq1 = {};
		int[] seq2 = {};
		Double result = SimilarityFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(1.0, is(equalTo(result)));
	}
	
	@Test 
	public void testCalculateJackardSimilarityCase2() {
		int[] seq1 = {1, 2, 3, 4};
		int[] seq2 = {2, 3, 4, 5};
		int intersectSize = 3;
		//Double result = SimilarityFinder.calculateJackardSimilarity(seq1, seq2);
		//assertThat(0.6, is(equalTo(result)));
	}

}
