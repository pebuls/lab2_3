package edu.iis.mto.similarity;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimilarityFinderTest {
	
	private MockSequenceSearcher mockSearcher;
	private SimilarityFinder finder;
	
	@Before
	public void setUp() throws Exception {
		
		mockSearcher = new MockSequenceSearcher();
		finder = new SimilarityFinder(mockSearcher);
	}

	@Test
	public void testCalculateJackardSimilarityOfEmptySequences() {

		int[] seq1 = {};
		int[] seq2 = {};
		double expectedResult = 1.0d;
		
		Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(equalTo(expectedResult)));
	}
	
	@Test
	public void testCalculateJackardSimilarityOfEqualSequences() {
		
		int[] seq1 = {1, 3, 5};
		int[] seq2 = {1, 3, 5};
		double expectedResult = 1.0d;
		
		Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(equalTo(expectedResult)));
	}
	
	@Test
	public void testCalculateJackardSimilarityOfEmptySequenceAndNonEmptySequence() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCalculateJackardSimilarityOfSequencesOfTheSameLengthWithNoEqualElements() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCalculateJackardSimilarityOfSequencesOfTheSameLengthWithSomeEqualElements() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCalculateJackardSimilarityOfSequencesOfDifferentLengthWithNoEqualElements() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCalculateJackardSimilarityOfSequencesOfDifferentLengthWithSomeEqualElements() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCalculateJackardSimilarityOfNullSequences() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCalculateJackardSimilarityInvocationsNumber() {
		fail("Not yet implemented");
	}
}
