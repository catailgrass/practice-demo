import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;
import static org.elasticsearch.common.xcontent.XContentFactory.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

public class TestClient {
    @Test
    public void coonectEs() {
        // on startup
        TransportClient client = null;
        try {
            Settings settings = Settings.builder()
                    .put("cluster.name", "elasticsearch")
                    .put("client.transport.ping_timeout", "3s")
                    .build();
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300))
                    .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

            XContentBuilder builder = jsonBuilder()
                    .startObject("info")
                        .field("user", "kimchy")
                        .field("postDate", new Date())
                        .field("message", "trying out Elasticsearch")
                    .endObject();
//                    .startArray("data")
//                        .array("")
            String json = Strings.toString(builder);
            System.out.println(json);
//            GetResponse getResponse = client.prepareGet("twitter", "tweet", "1").get();
            SearchResponse searchResponse = client.prepareSearch().get();
            System.out.println(searchResponse.toString());
//            IndexResponse response = client.prepareIndex("twitter", "tweet","1")
//                    .setSource(builder)
//                    .get();
//            System.out.println(response.getIndex());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            client.close();
        }
// on shutdown
    }
}
