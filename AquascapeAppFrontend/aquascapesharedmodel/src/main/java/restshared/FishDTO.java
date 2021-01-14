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

    public int getFishId() {
        return FishId;
    }

    public void setFishId(int fishId) {
        FishId = fishId;
    }

    public String getFishName() {
        return FishName;
    }

    public void setFishName(String fishName) {
        FishName = fishName;
    }

    public FishType getFishType() {
        return FishType;
    }

    public void setFishType(FishType fishType) {
        FishType = fishType;
    }

    public FishSize getFishSize() {
        return FishSize;
    }

    public void setFishSize(FishSize fishSize) {
        FishSize = fishSize;
    }
}
