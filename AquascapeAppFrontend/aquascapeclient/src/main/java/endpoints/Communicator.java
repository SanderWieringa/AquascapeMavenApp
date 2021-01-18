package endpoints;

import java.beans.PropertyChangeSupport;

public abstract class Communicator{
    final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
}
