package aquascapeshared;

public class CommunicatorWebSocketMessage {
    private CommunicatorWebSocketMessageOperation message;

    private Object[] parameters;

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public CommunicatorWebSocketMessageOperation getMessage() {
        return message;
    }

    public void setMessage(CommunicatorWebSocketMessageOperation message) {
        this.message = message;
    }
}
