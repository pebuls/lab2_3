package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class SearchResultMocked implements SearchResult{
	
	private int position;
	private boolean isFound;
	
	public SearchResultMocked(int position, boolean isFound) {
		super();
		this.position = position;
		this.isFound = isFound;
	}

	public boolean isFound() {
		return isFound;
	}

	public int getPosition() {
		return position;
	}
}
