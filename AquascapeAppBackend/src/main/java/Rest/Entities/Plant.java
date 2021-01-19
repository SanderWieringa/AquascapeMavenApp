package Rest.Entities;

import javax.persistence.*;

@Entity
public class Plant {
    @Column(unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int plantId;
    private String plantName;
    private int difficulty;

    public Plant(int plantId, String plantName, int difficulty) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.difficulty = difficulty;
    }

    public Plant() {

    }
}