/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

/**
 *
 * @author jankowskirobert
 */
public class DummySequenceSearcher implements SequenceSearcher {

    public SearchResult search(int i, int[] ints) {
        if(ints == null || ints.length == 0)
            throw new IllegalArgumentException("Empty sequence");
        
        int lo = 0;
        int hi = ints.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (i < ints[mid]) hi = mid - 1;
            else if (i > ints[mid]) lo = mid + 1;
            else return new DummySearchResult(mid, true);
        }
        return new DummySearchResult(-1, false);
    
    }
    
}
