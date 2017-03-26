package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherImpl implements SequenceSearcher {

	public SearchResult search(int key, int[] seq) {
		for (int j = 0; j < seq.length; j++) {
			if (seq[j] == key) {
				return new SearchResultImpl(true, j);
			}
		}
		return new SearchResultImpl(false, -1);

	}
}