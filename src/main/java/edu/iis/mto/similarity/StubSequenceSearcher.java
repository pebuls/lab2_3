package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;


public class StubSequenceSearcher implements SequenceSearcher {
    private int callCounter =0;
    private int key;
    private int[] seq = {};
    public int getCallCounter(){return callCounter;}
    public int getKey() {return key;}
    public int[] getSeq() {return seq;}

    public SearchResult search(int key, int[] ints) {
        this.key = key;
        this.seq = ints;
        ++callCounter;
        if(ints.length==0){
            throw new IllegalArgumentException();
        }
        for(int i=0;i<ints.length;i++){
            if(ints[i]==key){
                return new StubSearchResult(true, i);
            }
        }
        return new StubSearchResult(false, -1);
    }


}
