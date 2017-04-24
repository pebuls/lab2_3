package edu.iis.mto.similarity;

import org.junit.Before;

public class SimilarityFinderTest {

    private MockSequenceSearcher mockSequenceSearcher;
    private SimilarityFinder finder;

    @Before
    public void setUp() throws Exception {
        mockSequenceSearcher = new MockSequenceSearcher();
        finder = new SimilarityFinder(mockSequenceSearcher);
    }
}