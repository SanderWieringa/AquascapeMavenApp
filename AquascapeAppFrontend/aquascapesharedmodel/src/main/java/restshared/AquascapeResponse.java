package restshared;

import java.util.List;

public class AquascapeResponse {
    private boolean success;

    private List<AquascapeDTO> aquascapes;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<AquascapeDTO> getAquascapes() {
        return aquascapes;
    }

    public void setAquascapes(List<AquascapeDTO> aquascapes) {
        this.aquascapes = aquascapes;
    }
}