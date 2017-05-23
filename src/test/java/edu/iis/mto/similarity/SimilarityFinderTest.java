package edu.iis.mto.similarity;

import edu.iis.mto.similarity.FakeSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimilarityFinderTest {

	private SimilarityFinder similarityFinder;
	private FakeSequenceSearcher fakeSequenceSearcher;

	@Before
	public void setUp() throws Exception {
		fakeSequenceSearcher = new FakeSequenceSearcher();
		similarityFinder = new SimilarityFinder(fakeSequenceSearcher);
	}

	@Test
	public void calculateJackardSimilarityForEmptySequences() throws Exception {
		int[] seq1 = {};
		int[] seq2 = {};
		final double expected = 1.0d;
		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(expected));
		final int expectedCalls = 0;
		assertThat(fakeSequenceSearcher.getCall(), is(expectedCalls));
	}

	@Test
	public void calculateJackardSimilarityForEqualSequences() throws Exception {
		int[] seq1 = { 1, 2, 3 };
		int[] seq2 = { 1, 2, 3 };
		final double expected = 1.0d;
		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(expected));
		final int expectedCalls = 0;
		assertThat(fakeSequenceSearcher.getCall(), is(expectedCalls));
	}

	@Test
	public void calculateJackardSimilarityForOneEmptySequence() throws Exception {
		int[] seq1 = { 1, 2, 3 };
		int[] seq2 = {};
		final double expected = 0.0d;
		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(expected));
		final int expectedCalls = 0;
		assertThat(fakeSequenceSearcher.getCall(), is(expectedCalls));
	}

	@Test
	public void calculateJackardSimilarityForDifferentSequences() throws Exception {
		int[] seq1 = { 1, 3 };
		int[] seq2 = { 2, 5 };
		final double expected = 0.0d;
		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(expected));
		final int expectedCalls = 0;
		assertThat(fakeSequenceSearcher.getCall(), is(expectedCalls));
	}

	@Test
	public void calculateJackardSimilarityForNotEqualSequences() throws Exception {
		int[] seq1 = { 1, 3 };
		int[] seq2 = { 2, 1 };
		final double expected = 1.0 / 3.0d;
		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(expected));
		final int expectedCalls = 0;
		assertThat(fakeSequenceSearcher.getCall(), is(expectedCalls));
	}

	@Test
	public void calculateJackardSimilarityForSequenceAsAPartOfOtherSequence() throws Exception {
		int[] seq1 = { 1, 2, 3 };
		int[] seq2 = { 1, 2, 3, 4 };
		final double expected = 3.0 / 4.0d;
		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(expected));
		final int expectedCalls = 0;
		assertThat(fakeSequenceSearcher.getCall(), is(expectedCalls));
	}

}