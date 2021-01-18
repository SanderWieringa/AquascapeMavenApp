package restshared;

import java.util.List;

public class PlantCollectionResponse {
    private boolean success;

    private List<PlantDTO> plants;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<PlantDTO> getPlants() {
        return plants;
    }

    public void setPlants(List<PlantDTO> plants) {
        this.plants = plants;
    }
}
