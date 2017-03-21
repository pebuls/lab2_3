package lab2_3;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

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

}
