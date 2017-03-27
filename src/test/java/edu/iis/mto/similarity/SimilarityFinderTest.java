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
	public void emptySequences() {
		int[] seq1 = {};
		int[] seq2 = {};
		
		Assert.assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(equalTo(1.0)));
		
		
	}
	
	

}
