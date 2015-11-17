package packtpub;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;

/**
 * Created by sakhtar on 21/11/2014.
 */
public class Get {
    public static void main(String[] args) {

        Client client = NativeClient.createTransportClient();

        try {
            GetResponse responseGet = client.prepareGet("website", "blog", "123")
                    .setOperationThreaded(false)
                    .execute()
                    .actionGet();

            System.out.println(responseGet.getSourceAsString());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
