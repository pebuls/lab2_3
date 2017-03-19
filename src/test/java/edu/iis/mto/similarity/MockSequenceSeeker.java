package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.ArrayList;
import java.util.List;

public class MockSequenceSeeker implements SequenceSearcher {

    private static class MockSearchResult implements SearchResult {

        private final boolean found;
        private final int position;

        private MockSearchResult(boolean found, int position) {
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

    public static class Call {
        public final int param;
        public final int[] sequence;

        public Call(int param, int[] sequence) {
            this.param = param;
            this.sequence = sequence;
        }
    }

    List<Call> calls = new ArrayList<Call>();

    public SearchResult search(int i, int[] ints) {
        calls.add(new Call(i, ints));
        for(int j = 0; j < ints.length; j++) {
            if(ints[j] == i) {
                return new MockSearchResult(true, j);
            }
        }
        return new MockSearchResult(false, -1);
    }
}
