package packtpub;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;

import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by sakhtar on 21/11/2014.
 */
public class Index {
    public static void main(String[] args) {

        Client client = NativeClient.createTransportClient();

        try {
            IndexResponse response = client.prepareIndex("website", "blog", "456")
                    .setSource(jsonBuilder()
                                    .startObject()
                                    .field("user", "suhael")
                                    .field("postDate", new Date())
                                    .field("message", "did this work")
                                    .endObject()
                    )
                    .execute()
                    .actionGet();

            System.out.println(response.getId());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
