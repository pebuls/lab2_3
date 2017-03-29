package edu.iis.mto.search;

public class MockSequenceSearcher implements SequenceSearcher{
	public SearchResult search(int key, int[] seq) {
		
		for (int at = 0; at < seq.length; at++) {
			if (seq[at] == key) {
				return new MockSearchResult(true, at);
			}
		}
		return new MockSearchResult();
	}
}
