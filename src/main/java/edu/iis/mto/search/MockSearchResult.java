package edu.iis.mto.search;

public class MockSearchResult implements SearchResult{
	
	public final int NOT_FOUND = -1;
	
	private boolean found;
	private int position;
	
	public boolean isFound() {
		return found;
	}
	
	public int getPosition() {
		return position;
	}
}
