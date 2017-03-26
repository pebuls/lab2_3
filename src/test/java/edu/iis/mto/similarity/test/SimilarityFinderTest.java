package edu.iis.mto.similarity.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.SequenceSearcherImpl;
import edu.iis.mto.similarity.SimilarityFinder;

public class SimilarityFinderTest {

	SequenceSearcher sequenceSearcher = new SequenceSearcherImpl();
 	SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
 
 	@Test
 	public void differentArraysTest() {
 
 		int[] seq1 = {1,2,3};
 		int[] seq2 = {10,20,30};
 
 		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
 
 		assertThat(result, is(equalTo(0.0)));
 	}
 	
 	@Test
 	public void sameArraysTest() {
 
 		int[] seq1 = {1,2,3};
 		int[] seq2 = {1,2,3};
 
 		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
 
 		assertThat(result, is(equalTo(1.0)));
 	}
 	
 	@Test
 	public void emptyArraysTest() {
 
 		int[] seq1 = {};
 		int[] seq2 = {};
 
 		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
 
 		assertThat(result, is(equalTo(1.0)));
 	}
}