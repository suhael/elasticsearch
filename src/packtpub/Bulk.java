package packtpub;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.Client;

import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.*;

/**
 * Created by sakhtar on 21/11/2014.
 */
public class Bulk {
    public static void main(String[] args) {

        Client client = NativeClient.createTransportClient();

        try {
            BulkRequestBuilder bulkRequest = client.prepareBulk();

// either use client#prepare, or use Requests# to directly build index/delete requests
            bulkRequest.add(client.prepareIndex("twitter", "tweet", "1")
                            .setSource(jsonBuilder()
                                            .startObject()
                                            .field("user", "kimchy")
                                            .field("postDate", new Date())
                                            .field("message", "trying out Elasticsearch")
                                            .endObject()
                            )
            );

            bulkRequest.add(client.prepareIndex("twitter", "tweet", "2")
                            .setSource(jsonBuilder()
                                            .startObject()
                                            .field("user", "kimchy")
                                            .field("postDate", new Date())
                                            .field("message", "another post")
                                            .endObject()
                            )
            );

            BulkResponse bulkResponse = bulkRequest.execute().actionGet();
            if (bulkResponse.hasFailures()) {
                // process failures by iterating through each bulk response item
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
