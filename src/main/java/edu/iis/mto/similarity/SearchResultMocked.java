package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class SearchResultMocked implements SearchResult{
	int position;
	boolean isFound;

	public boolean isFound() {
		return isFound;
	}

	public int getPosition() {
		return position;
	}
	

}
