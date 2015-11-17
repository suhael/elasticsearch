package packtpub;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.Client;

/**
 * Created by sakhtar on 21/11/2014.
 */
public class Delete {
    public static void main(String[] args) {

        Client client = NativeClient.createTransportClient();

        try {
            DeleteResponse response = client.prepareDelete("twitter", "tweet", "1")
                    .execute()
                    .actionGet();

            System.out.println(response.isFound());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
