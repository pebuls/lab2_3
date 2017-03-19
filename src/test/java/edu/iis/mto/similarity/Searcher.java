package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sasho on 2017-03-17.
 */
public class Searcher implements SequenceSearcher {
    public int callCount;
    public List<int []> params = new ArrayList<int[]>();
    public List<Integer> params2 = new ArrayList<Integer>();
    public SearchResult search(int i, int[] ints) {
        callCount++ ;
        this.params.add(ints);
        this.params2.add(i);
        for (int j = 0; j< ints.length; j++){
            if(ints[j] == i){
                return new MockSearchResult(true, j);
            }
        }
        return new MockSearchResult(false, -1);
    }
}
