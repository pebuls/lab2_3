package mockClasses;

import com.google.common.primitives.Ints;
import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

/**
 * Created by Wojciech Szczepaniak on 20.03.2017.
 */
public class MockSequenceSearcher implements SequenceSearcher {
    public SearchResult search(int i, int[] ints) {
        return new MockSearchResult(Ints.asList(ints).indexOf(i));
    }
}
