package restshared;

public class FishDTO {
    private int fishId;
    private String FishName;
    private FishType fishType;
    private FishSize fishSize;

    public FishDTO(int fishId, String fishName, FishType fishType, FishSize fishSize) {
        this.fishId = fishId;
        FishName = fishName;
        this.fishType = fishType;
        this.fishSize = fishSize;
    }

    public int getFishId() {
        return fishId;
    }

    public void setFishId(int fishId) {
        this.fishId = fishId;
    }

    public String getFishName() {
        return FishName;
    }

    public void setFishName(String fishName) {
        FishName = fishName;
    }

    public FishType getFishType() {
        return fishType;
    }

    public void setFishType(FishType fishType) {
        this.fishType = fishType;
    }

    public FishSize getFishSize() {
        return fishSize;
    }

    public void setFishSize(FishSize fishSize) {
        this.fishSize = fishSize;
    }
}
