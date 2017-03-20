package mockClasses;

import edu.iis.mto.search.SearchResult;

/**
 * Created by Wojciech Szczepaniak on 20.03.2017.
 */
public class MockSearchResult implements SearchResult {

    private final static int NOT_FOUND = -1;
    private int position;

    public MockSearchResult(int position) {
        this.position = position;
    }

    public boolean isFound() {
        return position != NOT_FOUND;
    }

    public int getPosition() {
        return 0;
    }

    public static MockSearchResult valueNotFound() {
        return new MockSearchResult(NOT_FOUND);
    }
}
