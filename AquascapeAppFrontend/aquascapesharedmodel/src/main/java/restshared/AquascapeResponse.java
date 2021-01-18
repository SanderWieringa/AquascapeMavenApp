package restshared;

import java.util.List;

public class AquascapeResponse {

    private String jwt;

    private boolean success;

    private List<AquascapeDTO> aquascapes;

    private List<PlantDTO> plantsInAquascape;

    public AquascapeResponse() {
    }

    public AquascapeResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<AquascapeDTO> getAquascapes() {
        return aquascapes;
    }

    public List<PlantDTO> getPlantsByAquascape() { return plantsInAquascape; }

    public void setAquascapes(List<AquascapeDTO> aquascapes) {
        this.aquascapes = aquascapes;
    }
}