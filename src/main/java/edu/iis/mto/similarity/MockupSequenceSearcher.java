package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

/**
 * Created by Konrad Gos on 18.03.2017.
 */
public class MockupSequenceSearcher implements SequenceSearcher {

    private int index = -1;
    private int[] seq = null;
    private int count = 0;

    public SearchResult search(int index, int[] seq) {

        this.index=index;
        this.seq=seq;
        count++;

        for (int i=0; i<seq.length; i++) {
            if(seq[i]==index) {
                return new MockupSearchResult(true, index);
            }
        }
        return new MockupSearchResult(false, -1);
    }

    public int getIndex() {
        return index;
    }

    public int[] getSeq() {
        return seq;
    }

    public int getCount() {
        return count;
    }
}
