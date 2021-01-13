package restshared;

import java.util.ArrayList;

public class AquascapeDTO {
    private ArrayList<PlantDTO> plantsInAquarium;
    private int AquascapeId;
    private String Name;
    private int Difficulty;

    public AquascapeDTO() {
        plantsInAquarium = new ArrayList<>();
        AquascapeId = 0;
        Name = "";
        Difficulty = 0;
    }

    public AquascapeDTO(int aquascapeId, String name, int difficulty) {
        AquascapeId = aquascapeId;
        Name = name;
        Difficulty = difficulty;
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
