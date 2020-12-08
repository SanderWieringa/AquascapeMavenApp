package Aquascape;


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

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
