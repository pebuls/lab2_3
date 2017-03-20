import edu.iis.mto.similarity.SimilarityFinder;
import mockClasses.MockSequenceSearcher;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Wojciech Szczepaniak on 20.03.2017.
 */
public class SimilarityFinderTest {

    private SimilarityFinder finder;

    @Before
    public void init() {
        finder = new SimilarityFinder(new MockSequenceSearcher());
    }
}
