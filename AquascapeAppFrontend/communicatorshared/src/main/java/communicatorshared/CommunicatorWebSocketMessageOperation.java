package communicatorshared;

public enum CommunicatorWebSocketMessageOperation {
    LOGIN,
    REGISTER,
    ADD_PLANT,
    CREATE_AQUASCAPE,
    EDIT_AQUASCAPE,
    REGISTER_PROPERTY,         // Register a property (client only)
    UNREGISTER_PROPERTY,       // Unregister a registered property (client only
    SUBSCRIBE_TO_PROPERTY,      // Subscribe to a property (client only)
    UNSUBSCRIBE_FROM_PROPERTY,  // Unsubscribe from a property (client only)
    UPDATE_PROPERTY,           // Update property (client and server)
}