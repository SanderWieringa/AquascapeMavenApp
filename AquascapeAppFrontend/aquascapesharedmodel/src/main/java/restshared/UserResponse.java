package restshared;

import java.util.List;

public class UserResponse {

    private UserDTO user;

    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public UserDTO postLoginRequest(UserDTO user) {
        this.user = user;
        return user;
    }

    public UserDTO getUser() {
        return user;
    }
}
