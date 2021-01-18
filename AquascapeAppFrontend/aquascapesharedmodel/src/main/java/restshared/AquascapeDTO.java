package restshared;

import java.util.ArrayList;

public class AquascapeDTO {
    private ArrayList<PlantDTO> plantsInAquarium;
    private ArrayList<FishDTO> fishInAquarium;
    private int aquascapeId;
    private String name;
    private int difficulty;

    public AquascapeDTO() {
        plantsInAquarium = new ArrayList<>();
        fishInAquarium = new ArrayList<>();
        aquascapeId = 0;
        name = "";
        difficulty = 0;
    }

    public AquascapeDTO(int aquascapeId, String name, int difficulty) {
        this.aquascapeId = aquascapeId;
        this.name = name;
        this.difficulty = difficulty;
    }

    public int getAquascapeId() {
        return aquascapeId;
    }

    public void setAquascapeId(int aquascapeId) {
        this.aquascapeId = aquascapeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public ArrayList<PlantDTO> getPlantsInAquarium() {
        return plantsInAquarium;
    }

    public void setPlantsInAquarium(ArrayList<PlantDTO> plantsInAquarium) {
        this.plantsInAquarium = plantsInAquarium;
    }
}
