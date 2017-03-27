package edu.iis.mto.similarity;


import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherMocked implements SequenceSearcher{

	private int counter = 0;
	
	public SearchResult search(int key, int[] seq) {
		counter+=1;
		for(int i=0; i<seq.length; i++) {
			if (seq[i] == key) {
				return new SearchResultMocked(i, true);
			}
		}
		
		return new SearchResultMocked(-1, false);
	}

	public int getCounter() {
		return counter;
	}

}
