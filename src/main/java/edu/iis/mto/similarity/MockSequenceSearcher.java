package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

/**
 * Created by Klaudia on 20.03.2017.
 */
public class MockSequenceSearcher implements SequenceSearcher {

    public SearchResult search(int i, int[] ints) {
        int pos = 0;
        for (int j : ints) {
            if (i == j) {
                return new MockSearchResult(true,pos);
            }
            pos++;
        }
        return new MockSearchResult(false, -1);
    }
}
