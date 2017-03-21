/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

/**
 *
 * @author jankowskirobert
 */
public class DummySearchResult implements SearchResult{

    private boolean shouldFound = false;
    private int position;

    public DummySearchResult(int position, boolean shouldFound ) {
        this.position = position;
        this.shouldFound = shouldFound;
    }
    
    public boolean isFound() {
        return shouldFound;
    }

    public int getPosition() {
        return position;
    }
    
}
