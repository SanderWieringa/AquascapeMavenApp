package Rest.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Account")
@Entity
public class User
{
    @Column(unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int userId;
    @ManyToMany
    private List<Aquascape> aquascapes = new ArrayList<>();
    @Column(unique=true, nullable=false)
    private String userName;
    @Column(nullable=false)
    private String password;

    public User(int userId, String userName, String password)
    {
        this.aquascapes = new ArrayList<>();
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