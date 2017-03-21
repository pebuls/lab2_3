/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author jankowskirobert
 */
public class DummySequenceSearcher implements SequenceSearcher {

    private int invocationCounter = 0;
    
    public SearchResult search(int i, int[] ints) {
        
        if(ints == null || ints.length == 0)
            throw new IllegalArgumentException("Empty sequence");
        invocationCounter++;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.addAll(IntStream.of(ints).boxed().collect(Collectors.toList()));
        if(list.contains(i))
            return new DummySearchResult(list.indexOf(i), true);
        return new DummySearchResult(-1, false);
    
    }

    public int getInvocationCounter() {
        return invocationCounter;
    }
    
    
    
}
