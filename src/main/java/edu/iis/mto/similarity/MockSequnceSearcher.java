package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

/**
 * Created by Piotrek on 18.03.2017.
 */
public class MockSequnceSearcher implements SequenceSearcher {

    public int callsCounter = 0;
    public int key = -1;
    public int seq[] = null;

    public SearchResult search(int key, int[] seq) {

        this.key = key;
        this.seq = seq;
        callsCounter++;

        for(int i = 0; i < seq.length; i++){
            if(seq[i] == key){
                return new MockSearchResult(true, i);
            }
        }
        return new MockSearchResult(false, -1);
    }
}
