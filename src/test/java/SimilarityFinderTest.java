import edu.iis.mto.similarity.MockSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;

/**
 * Created by Piotr on 18.03.2017.
 */
public class SimilarityFinderTest {

    private MockSequenceSearcher mockSequenceSearcher = new MockSequenceSearcher();
    private SimilarityFinder similarityFinder = new SimilarityFinder(mockSequenceSearcher);

}
