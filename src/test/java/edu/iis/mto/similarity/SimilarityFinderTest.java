package edu.iis.mto.similarity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.CoreMatchers.*;


public class SimilarityFinderTest {
	
	private SequenceSearcherMocked sequenceSearcher;
	private SimilarityFinder similarityFinder;

	@Before
	public void setUp() {
		sequenceSearcher = new SequenceSearcherMocked();
		similarityFinder = new SimilarityFinder(sequenceSearcher);
	}
	
	@Test
	public void emptySequencesTest() {
		int[] seq1 = {};
		int[] seq2 = {};
		
		Assert.assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(equalTo(1.0)));
	}
	
	@Test
	public void firstEmptySequenceTest() {
		int[] seq1 = {};
		int[] seq2 = {1, 2, 3, 4, 5};
		
		Assert.assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(equalTo(0.0)));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void secondEmptySequenceTest() {
		int[] seq1 = {1, 2, 3, 4, 5};
		int[] seq2 = {};
		similarityFinder.calculateJackardSimilarity(seq1, seq2);
		Assert.assertThat(sequenceSearcher.getCounter(), is(equalTo(0)));
	}
	
	public void differentSequencesTest() {
		int[] seq1 = {1, 2, 3, 4, 5};
		int[] seq2 = {6, 7, 8, 9, 10};
		Assert.assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(equalTo(0.0)));
		Assert.assertThat(sequenceSearcher.getCounter(), is(equalTo(5)));
	}
	
	public void sameSequencesTest() {
		int[] seq1 = {1, 2, 3, 4, 5};
		int[] seq2 = {1, 2, 3, 4, 5};
		Assert.assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(equalTo(5.0)));
		Assert.assertThat(sequenceSearcher.getCounter(), is(equalTo(5)));
	}
	
	
	
	

}
