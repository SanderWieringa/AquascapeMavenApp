package listeners;

import endpoints.AquascapeEndPoint;
import javafx.application.Platform;
import org.controllers.AquascapeViewController;
import org.controllers.HomeViewController;
import restshared.AquascapeResponse;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CreateAquascapeChangeListener implements PropertyChangeListener {

    private AquascapeViewController aquascapeViewController;

    private final AquascapeEndPoint aquascapeEndPoint;

    public CreateAquascapeChangeListener(AquascapeViewController aquascapeViewController, AquascapeEndPoint aquascapeEndPoint) {
        this.aquascapeViewController = aquascapeViewController;
        this.aquascapeEndPoint = aquascapeEndPoint;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                aquascapeViewController.showAquascape((AquascapeResponse)evt.getNewValue());
            }
        });
        aquascapeEndPoint.removeListener("CREATEAQUASCAPE", this);
    }
}
