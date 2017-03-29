package edu.iis.mto.similarity;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import edu.iis.mto.search.*;

public class SimilarityFinderTest {
	MockSearchResult mockSearchResult = new MockSearchResult();
	MockSequenceSearcher mockSequenceSearcher = new MockSequenceSearcher();
	SimilarityFinder similarityFinder = new SimilarityFinder(mockSequenceSearcher);
	
	@Test
	public void twoEmptyArrays() {
		int[] seq1 = new int[0];
		int[] seq2 = new int[0];
		
		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
		double expectedResult = 1.0;
		
		assertThat(result, is(equalTo(expectedResult)));
	}
	
	@Test
	public void twoSameArrays() {
		int[] seq1 = {10, 20, 30, 40, 50};
		int[] seq2 = {10, 20, 30, 40, 50};
		
		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
		double expectedResult = 1.0;
		
		assertThat(result, is(equalTo(expectedResult)));
	}
	
	@Test
	public void twoDifferentArrays() {
		int[] seq1 = {10, 20, 30, 40, 50};
		int[] seq2 = {60, 70, 80, 90, 100};
		
		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
		double expectedResult = 0.0;
		
		assertThat(result, is(equalTo(expectedResult)));
	}
	
	@Test
	public void twoSameLengthArraysWithOneElementDifferent() {
		int[] seq1 = {10, 20, 30, 40, 50};
		int[] seq2 = {10, 20, 30, 40, 60};
		
		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
		double expectedResult = (double) 4/6;
		
		assertThat(result, is(equalTo(expectedResult)));
	}
	
	@Test(expected = NullPointerException.class)
	public void nullArrays() {
		int[] seq1 = null;
		int[] seq2 = null;
		
		similarityFinder.calculateJackardSimilarity(seq1, seq2);
	}
	
	@Test(expected = NullPointerException.class)
	public void nullArray() {
		int[] seq1 = {10, 20, 30};
		int[] seq2 = null;
		
		similarityFinder.calculateJackardSimilarity(seq1, seq2);
	}
}
