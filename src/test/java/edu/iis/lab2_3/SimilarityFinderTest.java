package edu.iis.lab2_3;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import edu.iis.mto.similarity.SearchForSequenceMocker;
import edu.iis.mto.similarity.SimilarityFinder;

public class SimilarityFinderTest {
	
	@Test
	public void testFindSimilarityEmptyArrays() {
		
		SearchForSequenceMocker mocker = new SearchForSequenceMocker();
		SimilarityFinder finder = new SimilarityFinder(mocker);
		int[] seq1 = new int[0];
		int[] seq2 = new int[0];
		double result = finder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(1.0)));
	}

}
