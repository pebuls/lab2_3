package edu.iis.mto.similarity;

import org.junit.Before;

import static org.junit.Assert.*;

public class SimilarityFinderTest {

    private MockSequenceSeeker mockSequenceSeeker;
    private SimilarityFinder finder;

    @Before
    public void setUp() throws Exception {
        mockSequenceSeeker = new MockSequenceSeeker();
        finder = new SimilarityFinder(mockSequenceSeeker);
    }
}