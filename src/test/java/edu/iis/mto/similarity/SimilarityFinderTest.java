package edu.iis.mto.similarity;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class SimilarityFinderTest {
	
	private SequenceSearcherMocked sequenceSearcher;
	private SimilarityFinder similarityFinder;

	@Test
	public void setUp() {
		sequenceSearcher = new SequenceSearcherMocked();
		similarityFinder = new SimilarityFinder(sequenceSearcher);
	}
	
	

}
