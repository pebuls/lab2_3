package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceMockFinder implements SequenceSearcher {
	private int callCount = 0;

	public int getCallCount() {
		return callCount;
	}

	public void setCallCount(int callCount) {
		this.callCount = callCount;
	}

	public SearchResult search(int key, int[] sequence) {
		callCount++;
		for (int i = 0; i < sequence.length; i++) {
			if(key == sequence[i]) {
				return new SequenceMockResult(true, i);
			}
		}
		return new SequenceMockResult(false, -1);
	}

}