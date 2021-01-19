package Rest.Entities;

import javax.persistence.*;

@Entity
public class Fish {
    @Column(unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int FishId;
    private String FishName;
    private FishType FishType;
    private  FishSize FishSize;

    public Fish(int fishId, String fishName, FishType fishType, FishSize fishSize) {
        FishId = fishId;
        FishName = fishName;
        FishType = fishType;
        FishSize = fishSize;
    }

    public Fish() {

    }

    public FishType getFishType() {
        return FishType;
    }

    public FishSize getFishSize() {
        return FishSize;
    }
}