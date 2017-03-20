package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class MockSequenceSearcher implements SequenceSearcher{
	
	public int callCounter = 0;
	public SearchResult search(int key, int[] seq) {
		callCounter++;
		for(int i = 0; i < seq.length; i++) {
			if(seq[i] == key){
				return new MockSearchResult(true, i);
			}
		}
		return new MockSearchResult();
	}
}
