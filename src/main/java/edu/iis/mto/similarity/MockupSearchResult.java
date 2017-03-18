package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

/**
 * Created by Konrad Gos on 18.03.2017.
 */
public class MockupSearchResult implements SearchResult {

    private boolean found;
    private int position;

    public boolean isFound() {
        return this.found;
    }

    public int getPosition() {
        return this.position;
    }
}
