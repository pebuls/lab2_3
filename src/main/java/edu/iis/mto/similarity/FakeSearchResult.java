package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class FakeSearchResult implements SearchResult {

	private int position;

	FakeSearchResult(int position) {
		this.position = position;
	}

	public boolean isFound() {
		return position != -1;
	}

	public int getPosition() {
		return position;
	}

}