package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.ArrayList;

/**
 * Created by grusz on 19.03.2017.
 */
public class MockSequenceSeeker implements SequenceSearcher {

    ArrayList<SearchMethodCall> calls = new ArrayList<SearchMethodCall>();

    private class MockSearchResult implements SearchResult {

        private final boolean found;
        private final int position;

        public MockSearchResult(boolean found, int position) {
            this.found = found;
            this.position = position;
        }

        public boolean isFound() {
            return found;
        }

        public int getPosition() {
            return position;
        }
    }

    public static class SearchMethodCall {
        private int searchedKey;
        private int[] searchedSequence;

        public SearchMethodCall(int searchedKey, int[] searchedSequence) {
            this.searchedKey = searchedKey;
            this.searchedSequence = searchedSequence;
        }

        public int getSearchedKey() {
            return searchedKey;
        }

        public int[] getSearchedSequence() {
            return searchedSequence;
        }
    }

    public SearchResult search(int i, int[] ints) {
        calls.add(i,ints);
        for(int j=0;j<ints.length;j++){
            if(ints[j]==i){
                return new MockSearchResult(true,j);
            }
        }
    }
}
