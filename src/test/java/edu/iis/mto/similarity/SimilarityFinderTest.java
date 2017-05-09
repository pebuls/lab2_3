package edu.iis.mto.similarity;

import edu.iis.mto.similarity.FakeSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.Before;

public class SimilarityFinderTest {

	private SimilarityFinder similarityFinder;
	private FakeSequenceSearcher fakeSequenceSearcher;

	@Before
	public void setUp() throws Exception {
		fakeSequenceSearcher = new FakeSequenceSearcher();
		similarityFinder = new SimilarityFinder(fakeSequenceSearcher);
	}
}