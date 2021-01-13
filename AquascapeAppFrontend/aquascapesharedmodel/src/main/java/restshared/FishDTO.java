package restshared;

public class FishDTO {
    private int FishId;
    private String FishName;
    private FishType FishType;
    private FishSize FishSize;

    public FishDTO(int fishId, String fishName, FishType fishType, FishSize fishSize) {
        FishId = fishId;
        FishName = fishName;
        FishType = fishType;
        FishSize = fishSize;
    }
}
