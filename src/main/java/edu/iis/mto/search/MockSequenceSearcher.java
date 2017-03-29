package edu.iis.mto.search;

public class MockSequenceSearcher implements SequenceSearcher{
	public SearchResult search(int key, int[] sequence) {
		return new MockSearchResult();
	}
}
