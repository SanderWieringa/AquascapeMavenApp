package restclient.controllers;

import Messages.UserMessage;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import restshared.AquascapeDTO;
import restshared.AquascapeResponse;
import restshared.UserDTO;
import restshared.UserResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserController {

    public static String jwtToken;

    private final String url = "http://localhost:3337";

    private final int NOTDEFINED = -1;

    //private static final Logger log = LoggerFactory.getLogger();

    private final Gson gson = new Gson();

    private UserMessage message;

    private UserResponse userResponse;

    AquascapeController aquascapeController = new AquascapeController();

    public void register(UserDTO user) {
        message = UserMessage.REGISTER;
        UserDTO userRequest = new UserDTO(user.getUserName(), user.getPassword());
        String queryPost = "/register";
        UserResponse response = executeQueryPost(userRequest, queryPost);
        if (response.isSuccess()) {

        }
    }

    public UserDTO login(UserDTO user) {
        message = UserMessage.LOGIN;
        UserDTO userRequest = new UserDTO(user.getUserName(), user.getPassword());
        String queryPost = "/authenticate";
        UserResponse response = executeQueryPost(userRequest, queryPost);
        if (response.isSuccess()) {
            // TODO: return aquascapes
            aquascapeController.getAquascapes();
        }
        return response.getUser();
    }

    private UserResponse executeQueryPost(UserDTO userRequest, String queryPost) {
        final String query = url + queryPost;
        System.out.println("[Query Post] : " + query);

        HttpPost httpPost = new HttpPost(query);
        httpPost.addHeader("content-type", "application/json");
        StringEntity params;
        try {
            params = new StringEntity(gson.toJson(userRequest));
            httpPost.setEntity(params);
        } catch (UnsupportedEncodingException e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
        }
        return executeHttpUriRequest(httpPost);
    }

    private UserResponse executeHttpUriRequest(HttpUriRequest httpUriRequest) {

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpUriRequest)) {
            System.out.println("[Status Line] : " + response.getStatusLine());
            HttpEntity entity = response.getEntity();
            final String entityString = EntityUtils.toString(entity);
            System.out.println("[Entity] : " + entityString);
            switch(message) {
                case LOGIN :
                    userResponse = gson.fromJson(entityString, UserResponse.class);
                    setJwtToken(entityString);
                    userResponse.setSuccess(true);
                    break;
                case REGISTER :
                    userResponse = gson.fromJson(entityString, UserResponse.class);
                    userResponse.setSuccess(true);
            }

            return userResponse;
        }
        catch (IOException e) {
            System.out.println("IOException : " + e.toString());
            userResponse = new UserResponse();
            userResponse.setSuccess(false);
            return userResponse;
        }
        catch (JsonSyntaxException e) {
            System.out.println("JsonSyntaxException : " + e.toString());
            userResponse = new UserResponse();
            userResponse.setSuccess(false);
            return userResponse;
        }
    }

    public static String getJwtToken() {
        return jwtToken;
    }

    public static void setJwtToken(String jwtToken) {
        UserController.jwtToken = jwtToken;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }
}
