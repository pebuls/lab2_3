package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

/**
 * Created by Piotrek on 18.03.2017.
 */
public class MockSearchResult implements SearchResult{

    private boolean found;
    private int position;

    public boolean isFound() {
        return false;
    }

    public int getPosition() {
        return 0;
    }
}
