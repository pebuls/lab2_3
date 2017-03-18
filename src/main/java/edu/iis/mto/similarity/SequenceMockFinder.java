package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceMockFinder implements SequenceSearcher {

	public SearchResult search(int key, int[] sequence) {
		for (int i = 0; i < sequence.length; i++) {
			if(key == sequence[i]) {
				return new SequenceMockResult(true, i);
			}
		}
		return new SequenceMockResult(false, -1);
	}

}