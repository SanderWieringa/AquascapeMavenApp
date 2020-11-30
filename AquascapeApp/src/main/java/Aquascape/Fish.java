package Aquascape;

public class Fish {
    private int FishId;
    private String FIshName;
    private FishType FishType;
    private int FishSize;

    public Fish(int fishId, String FIshName, FishType fishType, int fishSize) {
        FishId = fishId;
        this.FIshName = FIshName;
        FishType = fishType;
        FishSize = fishSize;
    }

    public Fish() {

    }

    public int getFishId() {
        return FishId;
    }

    public void setFishId(int fishId) {
        FishId = fishId;
    }

    public String getFIshName() {
        return FIshName;
    }

    public void setFIshName(String FIshName) {
        this.FIshName = FIshName;
    }

    public FishType getFishType() {
        return FishType;
    }

    public void setFishType(FishType fishType) {
        FishType = fishType;
    }

    public int getFishSize() {
        return FishSize;
    }

    public void setFishSize(int fishSize) {
        FishSize = fishSize;
    }




}
