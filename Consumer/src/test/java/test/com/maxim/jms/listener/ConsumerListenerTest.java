package test.com.maxim.jms.listener;

import com.maxim.jms.listner.ConsumerListener;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.jms.TextMessage;

import static org.junit.Assert.assertNull;

/**
 * Created by lede on 8/19/16.
 */
public class ConsumerListenerTest {

    private TextMessage message;

    @Before
    public void setUp() throws Exception{

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testOnMessage() {
        ConsumerListener listener = new ConsumerListener();
        listener.onMessage(message);
        assertNull(message);
    }
}
