package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

/**
 * Created by Konrad Gos on 18.03.2017.
 */
public class MockupSequenceSearcher implements SequenceSearcher {

    public SearchResult search(int index, int[] seq) {
        for (int i=0; i<seq.length; i++) {
            if(seq[i]==index) {
                return new MockupSearchResult(true, index);
            }
        }
        return new MockupSearchResult(false, -1);
    }
}
