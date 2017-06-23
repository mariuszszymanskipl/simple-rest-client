package api;

import domain.Category;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Mariusz Szymanski
 */
public class ICDClientTest {

    private ICDClient icdClient;

    @Before
    public void setUp() {
        icdClient = new ICDClient();
    }

    @Test
    public void getICDShouldReturnNotNullList() throws Exception {
        List<Category> classification = icdClient.getICDClassification();
        assertTrue(classification.size() != 0);
    }

}