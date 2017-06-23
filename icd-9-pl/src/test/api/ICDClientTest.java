package api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Mariusz Szymanski
 */
public class ICDClientTest {

    private ICDClient icdClient;

    @Before
    public void setUp(){
        icdClient = new ICDClient();
    }

    @Test
    public void getICD() throws Exception {
        int result = icdClient.getICD();
        assertTrue(result != 0);
    }

}