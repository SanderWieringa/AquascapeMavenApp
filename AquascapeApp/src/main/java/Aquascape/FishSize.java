package Aquascape;

public enum FishSize {
    SMALL(1),
    MEDIUM(3),
    LARGE(5);

    private final int size;
    private FishSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
