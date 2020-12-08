package Aquascape;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Aquascape {
    @ManyToMany
    private List<Plant> plantsInAquarium;
    @ManyToMany
    private List<Fish> fishInAquarium;
    @Column(unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int AquascapeId;
    @NotNull
    private String Name;
    private int Difficulty;


    public Aquascape(int AquascapeId, String Name, int Difficulty) {
        this.plantsInAquarium = new ArrayList<Plant>();
        this.fishInAquarium = new ArrayList<Fish>();
        this.AquascapeId = AquascapeId;
        this.Name = Name;
        this.Difficulty = Difficulty;
    }

    public Aquascape() {
        this.plantsInAquarium = new ArrayList<Plant>();
        this.fishInAquarium = new ArrayList<Fish>();
    }

    public synchronized void addFish(Fish fish) {
        fishInAquarium.add(fish);
    }

    public synchronized void addPlant(Plant plant) {
        plantsInAquarium.add(plant);
    }

    public List<Plant> getPlantsInAquarium() {
        return plantsInAquarium;
    }

    public List<Fish> getFishInAquarium() {
        return fishInAquarium;
    }

    public int getAquascapeId() {
        return AquascapeId;
    }

    public void setAquascapeId(int aquascapeId) {
        AquascapeId = aquascapeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getDifficulty() {
        return Difficulty;
    }

    public void setDifficulty(int difficulty) {
        Difficulty = difficulty;
    }


}
