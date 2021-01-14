package restclient.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import restshared.AquascapeDTO;
import restshared.AquascapeResponse;

import java.io.IOException;
import java.util.List;

public class AquascapeController {
    private final String url = "http://localhost:3337";

    //private static final Logger log = LoggerFactory.getLogger();

    private final Gson gson = new Gson();

    public List<AquascapeDTO> getAquascapes() {
        String queryGet = "/aquascapes";
        AquascapeResponse response = executeQueryGet(queryGet);
        return response.getAquascapes();
    }

    private AquascapeResponse executeQueryGet(String queryGet) {
        final String query = url + queryGet;
        //log.info("[Query Get] : " + query);

        HttpGet httpGet = new HttpGet(query);
        return executeHttpUriRequest(httpGet);
    }

    private AquascapeResponse executeHttpUriRequest(HttpUriRequest httpUriRequest) {
        try(CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(httpUriRequest)){
            //log.info("[Status Line] : " + response.getStatusLine());
            HttpEntity entity = response.getEntity();
            final String entityString = EntityUtils.toString(entity);
            //log.info("[Entity] : " + entityString);
            AquascapeResponse aquascapeReponse = gson.fromJson(entityString, AquascapeResponse.class);
            return aquascapeReponse;
        }
        catch (IOException e) {
            //log.info("IOException : " + e.toString());
            AquascapeResponse aquascapeResponse = new AquascapeResponse();
            aquascapeResponse.setSuccess(false);
            return aquascapeResponse;
        }
        catch (JsonSyntaxException e) {
            //log.info("JsonSyntaxException : " + e.toString());
            AquascapeResponse aquascapeResponse = new AquascapeResponse();
            aquascapeResponse.setSuccess(false);
            return aquascapeResponse;
        }
    }
}
