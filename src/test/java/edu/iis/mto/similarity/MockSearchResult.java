package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

/**
 * Created by Sasho on 2017-03-17.
 */
public class MockSearchResult implements SearchResult {

    private boolean found;
    private int position;

    MockSearchResult (boolean found, int position){
        this.found = found;
        this.position = position;
    }

    public boolean isFound() {
        return this.found;
    }

    public int getPosition() {
        return this.position;
    }
}