package org.example;

public class Fish {
    private int FishId;
    private String FishName;
    private FishType FishType;
    private FishSize FishSize;

    public Fish(int fishId, String fishName, org.example.FishType fishType, org.example.FishSize fishSize) {
        FishId = fishId;
        FishName = fishName;
        FishType = fishType;
        FishSize = fishSize;
    }
}
