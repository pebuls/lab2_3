package edu.iis.mto.search;

public class MockSearchResult implements SearchResult{
	
	public boolean isFound() {
		return false;
	}
	
	public int getPosition() {
		return -1;
	}
}
