package listeners;

import endpoints.AquascapeEndPoint;
import javafx.application.Platform;
import org.controllers.HomeViewController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GetAllAquascapesChangeListener implements PropertyChangeListener{

    private HomeViewController homeController;
    private AquascapeEndPoint aquascapeEndPoint;

    public GetAllAquascapesChangeListener(HomeViewController homeController, AquascapeEndPoint aquascapeEndPoint) {
        this.homeController = homeController;
        this.aquascapeEndPoint = aquascapeEndPoint;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                homeController.getAquascapes();
            }
        });


    }
}
