package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.example.Aquascape;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.*;

public class AquascapeController {

    private SSLContexts HttpClients;

    public ObservableList<Aquascape> getAquascapes() throws IOException {
        ObservableList<Aquascape> aquascapes = FXCollections.observableArrayList();

        URL url = new URL("localhost:3337/plants");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("GET");
        http.setDoOutput(true);

        /*SSLContext httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("localhost:3337/plants");

        CloseableHttpResponse response = httpclients.execute(httpGet);*/

        /*URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("localhost:3337")
                .setPath("plants")
                .build();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:3337/aquascapes");
        CloseableHttpResponse response = httpClient.execute(httpGet);*/
        aquascapes.add(new Aquascape(1, "MyAquascape", 1));
        aquascapes.add(new Aquascape(2, "second aquascape", 3));

        return aquascapes;
    }
}