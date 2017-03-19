package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;


public class MockSequenceSearcher implements SequenceSearcher {
    private int callCounter =0;
    public int getCallCounter(){return callCounter;}
    public SearchResult search(int key, int[] ints) {
        ++callCounter;
        if(ints.length==0){
            throw new IllegalArgumentException();
        }
        for(int i=0;i<ints.length;i++){
            if(ints[i]==key){
                return new MockSearchResult(true, i);
            }
        }
        return new MockSearchResult(false, -1);
    }
}
