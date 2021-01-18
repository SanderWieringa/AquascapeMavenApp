package restclient.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import restshared.AquascapeCollectionResponse;
import restshared.AquascapeDTO;
import restshared.AquascapeResponse;

import java.io.IOException;
import java.util.List;

public class AquascapeCollectionController {
    private final String url = "http://localhost:3337";

    private AquascapeCollectionResponse aquascapeResponse;

    private final Gson gson = new Gson();

    public List<AquascapeDTO> getAquascapes() {
        String queryGet = "/aquascapes";
        AquascapeCollectionResponse response = executeQueryGet(queryGet);
        return response.getAquascapes();
    }

    private AquascapeCollectionResponse executeQueryGet(String queryGet) {
        final String query = url + queryGet;
        System.out.println("[Query Get] : " + query);

        HttpGet httpGet = new HttpGet(query);
        //httpGet.setHeader("Authorization", "Bearer " + UserController.jwtToken);
        return executeHttpUriRequest(httpGet);
    }

    private AquascapeCollectionResponse executeHttpUriRequest(HttpUriRequest httpUriRequest) {
        try(CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(httpUriRequest)){
            System.out.println("[Status Line] : " + response.getStatusLine());
            HttpEntity entity = response.getEntity();
            final String entityString = EntityUtils.toString(entity);
            System.out.println("[Entity] : " + entityString);
            aquascapeResponse = gson.fromJson(entityString, AquascapeCollectionResponse.class);
            return aquascapeResponse;
        }
        catch (IOException e) {
            System.out.println("IOException : " + e.toString());
            AquascapeCollectionResponse aquascapeResponse = new AquascapeCollectionResponse();
            aquascapeResponse.setSuccess(false);
            return aquascapeResponse;
        }
        catch (JsonSyntaxException e) {
            System.out.println("JsonSyntaxException : " + e.toString());
            AquascapeCollectionResponse aquascapeResponse = new AquascapeCollectionResponse();
            aquascapeResponse.setSuccess(false);
            return aquascapeResponse;
        }
    }
}
