package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class DummySearchResult implements SearchResult {

	private boolean elementFound;
	private int position;
	
	public DummySearchResult(boolean elementFound, int position) {
		this.elementFound = elementFound;
		this.position = position;
	}

	public boolean isFound() {
		return elementFound;
	}

	public int getPosition() {
		return position;
	}

}
