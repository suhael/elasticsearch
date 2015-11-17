package packtpub;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;


/**
 * Created by sakhtar on 21/11/2014.
 */
public class Search {
    public static void main(String[] args) {
        Client client = NativeClient.createTransportClient();

        //QueryBuilder qb = QueryBuilders.matchQuery("last_name", "smith");
        QueryBuilder qb = QueryBuilders.fuzzyQuery("last_name", "smoth");
        SearchResponse response = client.prepareSearch("megacorp").setTypes("employee").setQuery(qb).execute().actionGet();

        System.out.println(response.toString());


    }
}
