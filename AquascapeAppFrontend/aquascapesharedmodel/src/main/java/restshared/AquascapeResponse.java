package restshared;

import org.example.Aquascape;

import java.util.List;

public class AquascapeResponse {

    private boolean success;

    private List<Aquascape> aquascapes;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Aquascape> getAquascapes() {
        return aquascapes;
    }

    public void setAquascapes(List<Aquascape> aquascapes) {
        this.aquascapes = aquascapes;
    }
}
