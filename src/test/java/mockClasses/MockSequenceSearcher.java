package mockClasses;

import com.google.common.primitives.Ints;
import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

/**
 * Created by Wojciech Szczepaniak on 20.03.2017.
 */
public class MockSequenceSearcher implements SequenceSearcher {

    private int call = 0;

    public int getCall() {
        int returned = call;
        call = 0;
        return returned;
    }

    public SearchResult search(int i, int[] ints) {
        ++call;
        return new MockSearchResult(Ints.asList(ints).indexOf(i));
    }
}
