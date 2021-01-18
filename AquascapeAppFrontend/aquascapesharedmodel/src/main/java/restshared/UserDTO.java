package restshared;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private int userId;
    private List<AquascapeDTO> aquascapes = new ArrayList<>();
    private String userName;
    private String password;

    public UserDTO(int userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public UserDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
