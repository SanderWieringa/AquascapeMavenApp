package Rest.Responses;

import Rest.Entities.Aquascape;

public class AquascapeResponse {
    private boolean success;

    private Aquascape aquascape;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Aquascape getAquascape() {
        return aquascape;
    }

    public void setAquascape(Aquascape aquascape) {
        this.aquascape = aquascape;
    }
}
