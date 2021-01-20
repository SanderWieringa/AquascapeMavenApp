package endpoints;

/*import Messages.UserMessage;
import Messages.WebSocketMessage;*/
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import communicatorshared.CommunicatorWebSocketMessage;
import communicatorshared.CommunicatorWebSocketMessageOperation;
import restshared.AquascapeDTO;
import restshared.AquascapeResponse;

import javax.websocket.*;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@ClientEndpoint
public class AquascapeEndPoint extends Communicator {

    private static AquascapeEndPoint instance = null;

    private final String uri = "ws://localhost:8096/communicator/";

    private Session session;

    private String message;

    private Gson gson = null;

    // Status of the webSocket client
    boolean  isRunning = false;

    public AquascapeEndPoint() {
        gson = new Gson();
    }

    public void addListener(String eventName, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(eventName, listener);
        System.out.println("New listener count after adding {%s}, count: %s" +  listener.getClass().getSimpleName() + propertyChangeSupport.getPropertyChangeListeners().length);
    }

    public void removeListener(String eventName, PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(eventName, listener);
        System.out.println("New listener count after removing {%s}, count: %s" + listener.getClass().getSimpleName() + propertyChangeSupport.getPropertyChangeListeners().length);
    }
    /**
     * Get singleton instance of this class.
     * Ensure that only one instance of this class is created.
     * @return instance of client web socket
     */
    public static AquascapeEndPoint getInstance() {
        if (instance == null) {
            System.out.println("[WebSocket Client create singleton instance]");
            instance = new AquascapeEndPoint();
        }
        return instance;
    }
    /**
     *  Start the connection.
     */
    public void start() {
        System.out.println("[WebSocket Client start connection]");
        if (!isRunning) {
            startClient();
            isRunning = true;
        }
    }
    /**
     *  Stop the connection.
     */
    public void stop() {
        System.out.println("[WebSocket Client stop]");
        if (isRunning) {
            stopClient();
            isRunning = false;
        }
    }

    @OnOpen
    public void onWebSocketConnect(Session session){
        System.out.println("[WebSocket Client open session] " + session.getRequestURI());
        this.session = session;
    }

    @OnMessage
    public void onWebSocketText(String message, Session session){
        this.message = message;
        System.out.println("[WebSocket Client message received] " + message);
        processMessage(message);
    }

    @OnError
    public void onWebSocketError(Session session, Throwable cause) {
        System.out.println("[WebSocket Client connection error] " + cause.toString());
    }

    @OnClose
    public void onWebSocketClose(CloseReason reason){
        System.out.print("[WebSocket Client close session] " + session.getRequestURI());
        System.out.println(" for reason " + reason);
        session = null;
    }

    public void sendRequestToServer(CommunicatorWebSocketMessage webSocketMessage) {

        String jsonMessage = gson.toJson(webSocketMessage);
        // Use asynchronous messaging.communication
        session.getAsyncRemote().sendText(jsonMessage);
    }

    /**
     * Get the latest message received from the websocket messaging.communication.
     * @return The message from the websocket messaging.communication
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the message, but no action is taken when the message is changed.
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Start a WebSocket client.
     */
    private void startClient() {
        System.out.println("[WebSocket Client start]");
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, new URI(uri));

        } catch (IOException | URISyntaxException | DeploymentException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Stop the client when it is running.
     */
    private void stopClient(){
        System.out.println("[WebSocket Client stop]");
        try {
            session.close();

        } catch (IOException ex){
            // do something useful eventually
            ex.printStackTrace();
        }
    }

    // Process incoming json message
    private void processMessage(String jsonMessage) {

        // Parse incoming message
        CommunicatorWebSocketMessage webSocketMessage;
        try {
            webSocketMessage = gson.fromJson(jsonMessage, CommunicatorWebSocketMessage.class);
        }
        catch (JsonSyntaxException ex) {
            System.out.println("[WebSocket Client ERROR: cannot parse Json message " + jsonMessage);
            return;
        }

        // Get the type of response
        CommunicatorWebSocketMessageOperation message;
        message = webSocketMessage.getOperation();

        // Obtain content from message
        Object[] parameters = webSocketMessage.getParameters();

        if (message != null) {
            switch (message) {
                case LOGIN:
                    break;
                case REGISTER:
                    break;
                case ADD_PLANT:
                    break;
                case CREATE_AQUASCAPE:
                    AquascapeResponse aquascapeResponse = (AquascapeResponse) parameters[0];
                    /*aquascapeResponse.setSuccess((boolean) parameters[0]);
                    aquascapeResponse.setAquascape((AquascapeDTO) parameters[1]);*/
                    propertyChangeSupport.firePropertyChange("CREATEAQUASCAPE", null, aquascapeResponse);

                    break;
                case EDIT_AQUASCAPE:
                    break;
                case REGISTER_PROPERTY:
                    break;
                case UNREGISTER_PROPERTY:
                    break;
                case SUBSCRIBE_TO_PROPERTY:
                    break;
                case UNSUBSCRIBE_FROM_PROPERTY:
                    break;
                case UPDATE_PROPERTY:
                    break;
            }
        }

        if (parameters == null) {
            System.out.println("[WebSocket Client ERROR: message without content]");
            return;
        }

    }
}