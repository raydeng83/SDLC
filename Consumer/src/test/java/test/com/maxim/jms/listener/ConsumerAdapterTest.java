package test.com.maxim.jms.listener;

import com.maxim.jms.adapter.ConsumerAdapter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Le on 8/19/2016 0019.
 */
public class ConsumerAdapterTest {

    private String json = "{vendorName:\"Microsofttest\",firstName:\"BobTest\",lastName:\"SmithTest\",address:\"123 Main test\",city:\"TulsaTest\",state:\"OKTest\",zip:\"71345Test\",email:\"Bob@microsoft.test\",phoneNumber:\"test-123-test\"}\n" ;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSendToMongo() {
        ConsumerAdapter adapter = new ConsumerAdapter();
        adapter.sendToMongo(json);
        assertNotNull(json);
    }
}
