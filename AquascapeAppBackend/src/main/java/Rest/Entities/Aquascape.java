package Rest.Entities;

import com.sun.istack.NotNull;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Aquascape
{
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Plant> plantsInAquarium;
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Fish> fishInAquarium;
    @Column(unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int aquascapeId;
    @NotNull
    private String name;
    private int difficulty;

    public Aquascape(int AquascapeId, String Name, int Difficulty)
    {
        this.plantsInAquarium = new ArrayList<>();
        this.fishInAquarium = new ArrayList<>();
        this.aquascapeId = AquascapeId;
        this.name = Name;
        this.difficulty = Difficulty;
    }

    public Aquascape()
    {
        this.plantsInAquarium = new ArrayList<>();
        this.fishInAquarium = new ArrayList<>();
    }

    public synchronized void addFish(Fish fish)
    {
        fishInAquarium.add(fish);
    }

    public synchronized void addPlant(Plant plant)
    {
        plantsInAquarium.add(plant);
    }

    public List<Plant> getPlantsInAquarium()
    {
        return plantsInAquarium;
    }

    public List<Fish> getFishInAquarium()
    {
        return fishInAquarium;
    }

    public int getAquascapeId() {
        return aquascapeId;

    }
}