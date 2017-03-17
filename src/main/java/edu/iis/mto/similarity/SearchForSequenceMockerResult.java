package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class SearchForSequenceMockerResult implements SearchResult {
	
	private boolean foundFlag = false;
	private int where = -1;
	
	public SearchForSequenceMockerResult(boolean b, int count) {
		this.foundFlag = b;
		this.where = count;
	}

	public boolean isFound() {
		return foundFlag;
	}

	public int getPosition() {
		return where;
	}

}