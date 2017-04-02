package edu.iis.mto.search;

public class MockSearchResult implements SearchResult{
	
	public final int NOT_FOUND = -1;
	
	private boolean found = false;
	private int position = NOT_FOUND;
	
	public MockSearchResult() {
		
	}
	
	public MockSearchResult(boolean found, int position) {
		this.found = found;
		this.position = position;
	}
	
	public boolean isFound() {
		return found;
	}
	
	public int getPosition() {
		return position;
	}
}
