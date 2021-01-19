package communicatorshared;

public class CommunicatorWebSocketMessage {

    // Operation that is requested at client side
    private CommunicatorWebSocketMessageOperation operation;

    // Property
    private Object[] parameters;

    public CommunicatorWebSocketMessageOperation getOperation() {
        return operation;
    }

    public void setOperation(CommunicatorWebSocketMessageOperation operation) {
        this.operation = operation;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
