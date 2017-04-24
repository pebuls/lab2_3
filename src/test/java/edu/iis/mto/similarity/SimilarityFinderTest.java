package edu.iis.mto.similarity;

import org.junit.Before;


public class SimilarityFinderTest {
    private SimilarityFinder similarityFinder;
    private MockSequenceSearcher mockSequenceSearcher;

    @Before
    public void setUp() throws Exception {
        mockSequenceSearcher = new MockSequenceSearcher();
        similarityFinder = new SimilarityFinder(mockSequenceSearcher);
    }

}