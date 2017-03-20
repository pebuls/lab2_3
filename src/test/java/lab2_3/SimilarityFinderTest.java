package lab2_3;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import edu.iis.mto.similarity.MockSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;

public class SimilarityFinderTest {
	
	private SimilarityFinder finder;
	private MockSequenceSearcher searcher;
	
	@Before
	public void initialize() {
		searcher = new MockSequenceSearcher();
		finder = new SimilarityFinder(searcher);
	}

	@Test (expected = NullPointerException.class)
	public void testWhenTwoArraysAreNull() {
		int seq1[] = null;
		int seq2[] = null;
		
		finder.calculateJackardSimilarity(seq1, seq2);
	}
	
	@Test
	public void testWhenTwoArraysAreEmpty() {
		int seq1[] = {};
		int seq2[] = {};
		double testValue = 1.0d;
		
		double result = finder.calculateJackardSimilarity(seq1, seq2);
		
		assertThat(result, is(testValue));
	}
	
	@Test
	public void testWhenTwoArraysHaveTheSameValues	() {
		int seq1[] = {1,4,7};
		int seq2[] = {1,4,7};
		double testValue = 1.0;
		
		double result = finder.calculateJackardSimilarity(seq1, seq2);
		
		assertThat(result, is(testValue));
	}

}
