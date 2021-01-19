package communicatorserver;

import Rest.Responses.AquascapeResponse;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import communicatorshared.CommunicatorWebSocketMessage;
import communicatorshared.CommunicatorWebSocketMessageOperation;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ServerEndpoint(value="/communicator/")
public class CommunicatorServerWebSocket {

    // All sessions
    private static final List<Session> sessions = new ArrayList<>();

    // Map each property to list of sessions that are subscribed to that property
    private static final Map<String,List<Session>> propertySessions = new HashMap<>();

    @OnOpen
    public void onConnect(Session session) {
        System.out.println("[WebSocket Connected] SessionID: " + session.getId());
        String message = String.format("[New client with client side session ID]: %s", session.getId());
        sessions.add(session);
        System.out.println("[#sessions]: " + sessions.size());
    }

    @OnMessage
    public void onText(String message, Session session) {
        System.out.println("[WebSocket Session ID] : " + session.getId() + " [Received] : " + message);
        handleMessageFromClient(message, session);
    }

    @OnClose
    public void onClose(CloseReason reason, Session session) {
        System.out.println("[WebSocket Session ID] : " + session.getId() + " [Socket Closed]: " + reason);
        sessions.remove(session);
    }

    @OnError
    public void onError(Throwable cause, Session session) {
        System.out.println("[WebSocket Session ID] : " + session.getId() + "[ERROR]: ");
        cause.printStackTrace(System.err);
    }

    // Handle incoming message from client
    private void handleMessageFromClient(String jsonMessage, Session session) {
        Gson gson = new Gson();
        CommunicatorWebSocketMessage wbMessage = null;
        try {
            wbMessage = gson.fromJson(jsonMessage,CommunicatorWebSocketMessage.class);
        }
        catch (JsonSyntaxException ex) {
            System.out.println("[WebSocket ERROR: cannot parse Json message " + jsonMessage);
            return;
        }

        // Operation defined in message
        CommunicatorWebSocketMessageOperation operation;
        operation = wbMessage.getMessage();

        // Process message based on operation
        Object[] property = wbMessage.getParameters();
        Object[] responseParameters = null;
        CommunicatorWebSocketMessageOperation communicatorWebSocketMessageOperation = null;

        if (null != operation && null != property && !"".equals(property)) {
            switch (operation) {
                case LOGIN:
                    break;

                case REGISTER:
                    break;
                case ADD_PLANT:
                    break;
                case CREATE_AQUASCAPE:
                AquascapeResponse aquascapeResponse = new AquascapeResponse();
                    aquascapeResponse.setSuccess(true);
                responseParameters = new Object[]{aquascapeResponse};
                communicatorWebSocketMessageOperation = CommunicatorWebSocketMessageOperation.CREATE_AQUASCAPE;

                CommunicatorWebSocketMessage communicatorWebSocketMessage = new CommunicatorWebSocketMessage();
                communicatorWebSocketMessage.setMessage(communicatorWebSocketMessageOperation);
                communicatorWebSocketMessage.setParameters(responseParameters);
                String jsonResponseMessage = gson.toJson(communicatorWebSocketMessage);
                sessions.forEach(sess -> sess.getAsyncRemote().sendText(jsonResponseMessage));
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
    }
}