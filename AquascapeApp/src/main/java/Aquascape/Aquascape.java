package Aquascape;

public class Aquascape {
    private int AquascapeId;
    private String Name;
    private int Difficulty;

    public Aquascape(int AquascapeId, String Name, int Difficulty) {
        this.AquascapeId = AquascapeId;
        this.Name = Name;
        this.Difficulty = Difficulty;
    }

    public Aquascape() {

    }

    public int getAquascapeId() {
        return AquascapeId;
    }

    public void setAquascapeId(int aquascapeId) {
        AquascapeId = aquascapeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getDifficulty() {
        return Difficulty;
    }

    public void setDifficulty(int difficulty) {
        Difficulty = difficulty;
    }


}
