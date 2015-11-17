package packtpub;

import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class App2 {

    private static String wsUrl = "http://10.100.135.98:9200";

    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.custom()
                .setRetryHandler(new MyRequestRetryHandler()).build();

        HttpPost method = new HttpPost(wsUrl+"/test-index/test-type/1");
        // Execute the method.

        try {
            CloseableHttpResponse response = client.execute(method);

            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + response.getStatusLine());
            }else{
                HttpEntity entity = response.getEntity();
                String responseBody = EntityUtils.toString(entity);
                System.out.println(responseBody);
            }

        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Release the connection.
            method.releaseConnection();
        }
    }
}
