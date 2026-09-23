package photomanager;

public class Camera extends Equipment {
    private boolean isFullFrame;

    public Camera(String brand, String model, String mount, boolean isFullFrame) {
        super(brand, model, mount);
        this.isFullFrame = isFullFrame;
    }

    @Override
    public String toString() {
        String sensor = isFullFrame ? "Full Frame" : "Crop";
        return "[Camera] " + super.toString() + " - " + sensor;
    }
}