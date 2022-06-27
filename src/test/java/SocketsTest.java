import lesson14.HttpClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SocketsTest {
    @Test
    void testSockets() {
        HttpClient httpClient = new HttpClient();
        httpClient.startConnection("127.0.0.1", 8081);
        String response = httpClient.sendMessage("hello world\nhello again");
        assertEquals("hello world", response);

    }
}
