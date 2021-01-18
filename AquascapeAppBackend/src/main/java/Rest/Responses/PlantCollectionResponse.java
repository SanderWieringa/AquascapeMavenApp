package Rest.Responses;

import Rest.Entities.Aquascape;
import Rest.Entities.Plant;

import java.util.List;

public class PlantCollectionResponse {
    private boolean success;

    private List<Plant> plants;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setAquascapes(List<Plant> plants) {
        this.plants = plants;
    }
}
