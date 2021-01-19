package restshared;

public class AquascapeResponse {

    private boolean success;

    private AquascapeDTO aquascape;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public AquascapeDTO getAquascape() {
        return aquascape;
    }

    public void setAquascape(AquascapeDTO aquascape) {
        this.aquascape = aquascape;
    }
}
