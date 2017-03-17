package lab2_3;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import edu.iis.mto.similarity.SearchForSequenceMocker;
import edu.iis.mto.similarity.SimilarityFinder;

public class TestSimilarityFinder {

	@Test (expected = NullPointerException.class)
	public void FindSimilarityNulls() {
		SearchForSequenceMocker mocker = new SearchForSequenceMocker();
		SimilarityFinder finder = new SimilarityFinder(mocker);
		int[] seq1 = null, seq2 = null;
		finder.calculateJackardSimilarity(seq1, seq2);
	}
	
	@Test
	public void FindSimilarityEmpty() {
		SearchForSequenceMocker mocker = new SearchForSequenceMocker();
		SimilarityFinder finder = new SimilarityFinder(mocker);
		int[] seq1 = new int[0], seq2 = new int[0];
		double result = finder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(1.0)));
	}
	
	@Test (expected =  java.lang.OutOfMemoryError.class)
	public void FindSimilarityFull() {
		SearchForSequenceMocker mocker = new SearchForSequenceMocker();
		SimilarityFinder finder = new SimilarityFinder(mocker);
		int[] seq1 = new int[Integer.MAX_VALUE], seq2 = new int[Integer.MAX_VALUE];
		double result = finder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(1.0)));
	}
	
	@Test
	public void FindSimilaritySame() {
		SearchForSequenceMocker mocker = new SearchForSequenceMocker();
		SimilarityFinder finder = new SimilarityFinder(mocker);
		int[] seq1 = {1, 2, 3};
		int[] seq2 = {1, 2, 3};
		double result = finder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(1.0)));
	}
	
	@Test
	public void FindSimilarityMostlySameSameLengths() {
		SearchForSequenceMocker mocker = new SearchForSequenceMocker();
		SimilarityFinder finder = new SimilarityFinder(mocker);
		int[] seq1 = {1, 2, 3};
		int[] seq2 = {1, 2, 4};
		double result = finder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(0.5)));
	}
	
	@Test
	public void FindSimilarityMostlySameNotSameLengths() {
		SearchForSequenceMocker mocker = new SearchForSequenceMocker();
		SimilarityFinder finder = new SimilarityFinder(mocker);
		int[] seq1 = {1, 2, 3};
		int[] seq2 = {1, 2, 3, 4};
		double result = finder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(0.75)));
	}
	
	@Test
	public void FindSimilarityDifferentSameLengths() {
		SearchForSequenceMocker mocker = new SearchForSequenceMocker();
		SimilarityFinder finder = new SimilarityFinder(mocker);
		int[] seq1 = {1, 2, 3};
		int[] seq2 = {4, 5, 6};
		double result = finder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(0.0)));
	}
	
	@Test
	public void FindSimilarityDifferentNotSameLengths() {
		SearchForSequenceMocker mocker = new SearchForSequenceMocker();
		SimilarityFinder finder = new SimilarityFinder(mocker);
		int[] seq1 = {1, 2, 3};
		int[] seq2 = {4, 5, 6, 7};
		double result = finder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(0.0)));
	}
	
	@Test
	public void SearchForSequenceMockerCorrectAmountOfCalls() {
		SearchForSequenceMocker mocker = new SearchForSequenceMocker();
		SimilarityFinder finder = new SimilarityFinder(mocker);
		int[] seq1 = {1, 2};
		int[] seq2 = {3, 4};
		finder.calculateJackardSimilarity(seq1, seq2);
		assertThat(mocker.howManyCalls, is(equalTo(2)));
	}
}
