package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class Searcher implements SequenceSearcher {
    public SearchResult search(int i, int[] ints) {
        for (int j = 0; j< ints.length; j++){
           if(ints[j] == i){
                return new MockSearchResult(true, j);
            }
        }
        return new MockSearchResult(false, -1);
    }
}
