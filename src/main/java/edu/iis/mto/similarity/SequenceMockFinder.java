package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceMockFinder implements SequenceSearcher {
	private int callCount = 0;
	private int key = -1;
	private int[] seq = null;

	public int getCallCount() {
		return callCount;
	}

	public int getKey() {
		return key;
	}

	public int[] getSeq() {
		return seq;
	}

	public SearchResult search(int key, int[] sequence) {
		this.key = key;
		seq = sequence;
		callCount++;
		for (int i = 0; i < sequence.length; i++) {
			if(key == sequence[i]) {
				return new SequenceMockResult(true, i);
			}
		}
		return new SequenceMockResult(false, -1);
	}

}