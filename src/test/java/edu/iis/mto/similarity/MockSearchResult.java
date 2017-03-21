package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class MockSearchResult implements SearchResult {
	
	private boolean found;
	private int position;
	
	public boolean isFound() {
		return found;
	}

	public int getPosition() {
		return position;
	}

}
