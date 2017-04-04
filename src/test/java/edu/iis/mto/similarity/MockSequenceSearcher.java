package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class MockSequenceSearcher implements SequenceSearcher {
	
	private int invocationsNumber = 0;
	
	public SearchResult search(int key, int[] seq) {
		
		this.invocationsNumber++;
		
		for (int i=0; i<seq.length; i++) {
			if (key == seq[i]) {
				return new MockSearchResult(true, i);
			}
		}
		
		return new MockSearchResult(false, -1);
	}
	
	public int getInvocationsNumber() {
		return this.invocationsNumber;
	}
}
