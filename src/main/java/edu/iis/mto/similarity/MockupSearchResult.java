package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

/**
 * Created by Konrad Gos on 18.03.2017.
 */
public class MockupSearchResult implements SearchResult {

    public boolean isFound() {
        return false;
    }

    public int getPosition() {
        return 0;
    }
}
