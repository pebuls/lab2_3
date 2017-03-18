package lab2_3;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import edu.iis.mto.similarity.SequenceMockFinder;
import edu.iis.mto.similarity.SimilarityFinder;



public class SimilarityFinderTests {
	SequenceMockFinder sMockFinder = new SequenceMockFinder();
	SimilarityFinder sFinder = new SimilarityFinder(sMockFinder);

	@Test
	public void testEmpty() {
		int[] seq1 = new int[0], seq2 = new int[0];
		double result = sFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(1.0)));		
	}
	
	@Test
	public void testSame() {
		int[] seq1 = {4,7,3}, seq2 = {7,3,4};
		double result = sFinder.calculateJackardSimilarity(seq1, seq2);
		assertThat(result, is(equalTo(1.0)));
	}

}
