package mockClasses;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

/**
 * Created by Wojciech Szczepaniak on 20.03.2017.
 */
public class MockSequenceSearcher implements SequenceSearcher {
    public SearchResult search(int i, int[] ints) {
        for (int l = 0; l < ints.length; ++l) {
            if (i == ints[l]) {
                return new MockSearchResult(l);
            }
        }
        return MockSearchResult.valueNotFound();
    }
}
