package restshared;

public class PlantDTO {
    private int plantId;
    private String plantName;
    private int difficulty;

    public PlantDTO(int plantId, String plantName, int difficulty) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.difficulty = difficulty;
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
