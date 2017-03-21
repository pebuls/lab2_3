package edu.iis.mto.similarity;

import org.junit.Before;

/**
 * Created by RFran on 21.03.2017.
 */
public class SimilarityFinderTest {

    private MockSequenceSeeker mockSequenceSeeker;
    private SimilarityFinder finder;

    @Before public void setUp() throws Exception {
        mockSequenceSeeker = new MockSequenceSeeker();
        finder = new SimilarityFinder(mockSequenceSeeker);
    }


}
