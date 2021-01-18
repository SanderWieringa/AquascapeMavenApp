package Messages;


public class WebSocketMessage {
    private UserMessage message;

    private Object[] parameters;

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public UserMessage getMessage() {
        return message;
    }

    public void setMessage(UserMessage message) {
        this.message = message;
    }
}