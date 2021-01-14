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
    private Rest.Entities.FishSize FishSize;

    public Fish(int fishId, String fishName, Rest.Entities.FishType fishType, Rest.Entities.FishSize fishSize) {
        FishId = fishId;
        FishName = fishName;
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

    public Rest.Entities.FishType getFishType() {
        return FishType;
    }

    public void setFishType(Rest.Entities.FishType fishType) {
        FishType = fishType;
    }

    public Rest.Entities.FishSize getFishSize() {
        return FishSize;
    }

    public void setFishSize(Rest.Entities.FishSize fishSize) {
        FishSize = fishSize;
    }
}