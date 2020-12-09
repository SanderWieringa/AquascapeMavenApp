package Rest.Entities;

import javax.persistence.*;

@Entity
public class Fish {
    @Column(unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int FishId;
    private String FishName;
    private Rest.Entities.FishType FishType;
    private int FishSize;

    public Fish(int fishId, String FishName, FishType fishType, int fishSize) {
        FishId = fishId;
        this.FishName = FishName;
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

    public int getFishSize() {
        return FishSize;
    }

    public void setFishSize(int fishSize) {
        FishSize = fishSize;
    }




}
