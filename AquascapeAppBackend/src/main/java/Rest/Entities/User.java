package Rest.Entities;

import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User
{
    @ManyToMany
    private List<Aquascape> aquascapes;
    @Column(unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int userId;
    private String userName;
    private String password;

    public User(int userId, String userName, String password)
    {
        this.aquascapes = new ArrayList<Aquascape>();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public User()
    {

    }

    public void addAquascape(Aquascape aquascape)
    {
        aquascapes.add(aquascape);
    }

    public List<Aquascape> getAquascapes()
    {
        return aquascapes;
    }

    public List<Aquascape> getAllAquascapesByUser()
    {
        return aquascapes;
    }

    public Aquascape getAquascapeById(int aquascapeId)
    {
        for (Aquascape aquascape:aquascapes) {
            if (aquascape.getAquascapeId() == aquascapeId)
            {
                return aquascape;
            }
        }
        return null;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }


}