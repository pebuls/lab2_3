package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class DummySequenceSearcher implements SequenceSearcher{

	public SearchResult search(int key, int[] seq) {
		for (int i = 0; i < seq.length; i++) {
			if(key == seq[i]) {
				return new DummySearchResult(true, i);
			}
		}
		return new DummySearchResult(false, -1);
	}

}
