package lab2_3;

import static org.junit.Assert.*;

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
	public void testThenTwoArraysAreNull() {
		int seq1[] = null;
		int seq2[] = null;
		
		finder.calculateJackardSimilarity(seq1, seq2);
	}

}
