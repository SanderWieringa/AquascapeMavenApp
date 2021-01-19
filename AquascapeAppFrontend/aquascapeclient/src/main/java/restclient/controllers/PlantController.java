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
import restshared.PlantCollectionResponse;
import restshared.PlantDTO;

import java.io.IOException;
import java.util.List;

public class PlantController {
    private final String url = "http://localhost:3337";

    private PlantCollectionResponse plantCollectionResponse;

    private final Gson gson = new Gson();

    public List<PlantDTO> getPlants() {
        String queryGet = "/plants";
        PlantCollectionResponse response = executeQueryGet(queryGet);
        return response.getPlants();
    }

    private PlantCollectionResponse executeQueryGet(String queryGet) {
        final String query = url + queryGet;
        System.out.println("[Query Get] : " + query);

        HttpGet httpGet = new HttpGet(query);
        //httpGet.setHeader("Authorization", "Bearer " + UserController.jwtToken);
        return executeHttpUriRequest(httpGet);
    }

    private PlantCollectionResponse executeHttpUriRequest(HttpUriRequest httpUriRequest) {
        try(CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(httpUriRequest)){
            System.out.println("[Status Line] : " + response.getStatusLine());
            HttpEntity entity = response.getEntity();
            final String entityString = EntityUtils.toString(entity);
            System.out.println("[Entity] : " + entityString);
            plantCollectionResponse = gson.fromJson(entityString, PlantCollectionResponse.class);
            return plantCollectionResponse;
        }
        catch (IOException e) {
            System.out.println("IOException : " + e.toString());
            PlantCollectionResponse plantCollectionResponse = new PlantCollectionResponse();
            plantCollectionResponse.setSuccess(false);
            return plantCollectionResponse;
        }
        catch (JsonSyntaxException e) {
            System.out.println("JsonSyntaxException : " + e.toString());
            PlantCollectionResponse plantCollectionResponse = new PlantCollectionResponse();
            plantCollectionResponse.setSuccess(false);
            return plantCollectionResponse;
        }
    }

    public ObservableList<PlantDTO> getPlantss() {
        ObservableList<PlantDTO> plants = FXCollections.observableArrayList();
        plants.add(new PlantDTO(1, "Valisneria", 2));
        plants.add(new PlantDTO(2, "Lotus", 4));

        return plants;
    }
}
