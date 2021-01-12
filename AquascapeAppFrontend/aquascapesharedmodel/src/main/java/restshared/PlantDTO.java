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
}
