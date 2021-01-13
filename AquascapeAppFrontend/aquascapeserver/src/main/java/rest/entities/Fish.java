package rest.entities;

import javax.persistence.*;

@Entity
public class Fish {
    @Column(unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int FishId;
    private String FishName;
    private FishType FishType;
    private FishSize FishSize;

    public Fish(int fishId, String FishName, FishType fishType, FishSize fishSize) {
        FishId = fishId;
        FishName = FishName;
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

    public String getFishName() {
        return FishName;
    }

    public void setFishName(String FishName) {
        this.FishName = FishName;
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
