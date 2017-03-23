package edu.iis.mto.similarity;

import java.util.ArrayList;
import java.util.List;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherImpl implements SequenceSearcher {

	private int count = 0;
	private List<int []> list = new ArrayList<int[]>();

	public SearchResult search(int key, int[] seq) {
		count++;
		list.add(seq);

		for (int j = 0; j < seq.length; j++) {
			if (seq[j] == key) {
				return new SearchResultImpl(true, j);
			}
		}
		return new SearchResultImpl(false, -1);

	}

	public int getCount(){
		return count;
	}

	public List<int []> getList(){
		return list;
	}
}
