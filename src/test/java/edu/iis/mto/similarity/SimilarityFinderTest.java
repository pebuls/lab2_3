package edu.iis.mto.similarity;

import static org.junit.Assert.*;

/**
 * Created by Piotrek on 18.03.2017.
 */
public class SimilarityFinderTest {

    private MockSequnceSearcher mockSequnceSearcher = new MockSequnceSearcher();
    private SimilarityFinder similarityFinder = new SimilarityFinder(mockSequnceSearcher);

}