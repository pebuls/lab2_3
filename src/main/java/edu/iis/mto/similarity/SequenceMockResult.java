package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class SequenceMockResult implements SearchResult {
	
	private boolean flag = false;
	private int position = -1;
	
	public SequenceMockResult(boolean b, int i) {
		this.flag = b;
		this.position = i;
	}

	public boolean isFound() {
		return flag;
	}

	public int getPosition() {
		return position;
	}

}
