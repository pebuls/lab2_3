package lab2_3;

import static org.hamcrest.CoreMatchers.*;


import org.junit.Assert;
import org.junit.Test;

import edu.iis.mto.similarity.MockSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;



public class SimilarityFinderTest {

	SimilarityFinder finder = new SimilarityFinder(new MockSequenceSearcher());
	
	@Test
	public void testCalculateJackardSimilarityOneSequenceIsNull() {
		
		int[] seq1 = {};
		int[] seq2 = {2, 4, 5, 7, 8};

		double result = finder.calculateJackardSimilarity(seq1, seq2);		
		Assert.assertThat(result, is(0d));
	}
	
	@Test
	public void testCalculateJackardSimilarityBothSequencesAreNull() {
		
		int[] seq1 = {}, seq2 = {};
		
		double result = finder.calculateJackardSimilarity(seq1, seq2);
		Assert.assertThat(result, is(1.0d));
	}
	
	
}
