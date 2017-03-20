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

    
    
    public boolean isFound() {
        return true;
    }

    public int getPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
