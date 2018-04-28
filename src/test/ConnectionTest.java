package test;

import edu.ser516.project4.server.model.Connection;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConnectionTest {

    @Test
    public void testConnectionModel() {
        Connection connection = Connection.getInstance();
        connection.setHost("localhost");
        connection.setPort(8025);
        assertEquals(connection.getHost(), "localhost");
        assertEquals(connection.getPort(), 8025);
    }

}