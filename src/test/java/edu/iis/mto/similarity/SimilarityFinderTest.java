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
	
	

}
