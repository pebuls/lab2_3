package lab2_3;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.DummySequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;

public class TSimilarityFinder {

	@Test
	public void similarityReturnsOneWhenBothSeqsAreEmpty() {
		int[] seq1 = new int[0];
		int[] seq2 = new int[0];

		SimilarityFinder similarityFinder = new SimilarityFinder(null);

		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

		Assert.assertThat(result, Matchers.is(Matchers.equalTo(1.0)));
	}

	@Test
	public void similarityReturnsOneWhenSeqsAreTheSame() {
		int[] seq1 = new int[] {1, 2, 3};
		int[] seq2 = new int[] {1, 2, 3};

		SequenceSearcher sequenceFinder = new DummySequenceSearcher();
		SimilarityFinder similarityFinder = new SimilarityFinder(sequenceFinder);

		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

		Assert.assertThat(result, Matchers.is(Matchers.equalTo(1.0)));
	}
	
	@Test
	public void similarityReturnsThreeFourths() {
		int[] seq1 = new int[] {1, 2, 3};
		int[] seq2 = new int[] {1, 2, 3, 4};

		SequenceSearcher sequenceFinder = new DummySequenceSearcher();
		SimilarityFinder similarityFinder = new SimilarityFinder(sequenceFinder);

		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

		Assert.assertThat(result, Matchers.is(Matchers.equalTo(0.75)));
	}
	
	@Test
	public void similarityReturnsZeroWhenSeqsAreSameLengthButHaveDifferentElements() {
		int[] seq1 = new int[] {1, 2, 3};
		int[] seq2 = new int[] {4, 5, 6};

		SequenceSearcher sequenceFinder = new DummySequenceSearcher();
		SimilarityFinder similarityFinder = new SimilarityFinder(sequenceFinder);

		double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

		Assert.assertThat(result, Matchers.is(Matchers.equalTo(0.00)));
	}
}
