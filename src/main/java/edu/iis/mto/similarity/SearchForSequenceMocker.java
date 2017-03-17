package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SearchForSequenceMocker implements SequenceSearcher {
	
	public int howManyCalls = 0;
	public int key = -1;
	public int seq[] = null;
	
	public SearchResult search(int key, int[] seq) {
		this.key = key;
		this.seq = seq;
		howManyCalls++;
		for (int count = 0; count < seq.length; count++) {
			if(key == seq[count]) {
				return new SearchForSequenceMockerResult(true, count);
			}
		}
		return new SearchForSequenceMockerResult(false, -1);
	}

}
