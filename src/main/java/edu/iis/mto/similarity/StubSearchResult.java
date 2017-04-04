package edu.iis.mto.similarity;
import edu.iis.mto.search.SearchResult;

public class StubSearchResult implements SearchResult {
    private boolean isFound;
    private int position;

    public StubSearchResult(boolean isFound, int position){
        this.isFound = isFound;
        this.position = position;
    }
    public boolean isFound() {
        return isFound;
    }

    public int getPosition() {
        return position;
    }
}
