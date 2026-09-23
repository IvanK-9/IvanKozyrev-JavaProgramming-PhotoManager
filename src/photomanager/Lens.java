package photomanager;

public class Lens extends Equipment {
    private int focalLength;
    private double aperture;

    public Lens(String brand, String model, String mount, int focalLength, double aperture) {
        super(brand, model, mount);
        this.focalLength = focalLength;
        this.aperture = aperture;
    }

    // Business logic: check if the lens has a fast aperture
    public boolean isFastLens() {
        return this.aperture <= 2.0;
    }

    @Override
    public String toString() {
        String fastStatus = isFastLens() ? " [Fast Lens]" : "";
        return "[Lens] " + super.toString() + " -> " + focalLength + "mm f/" + aperture + fastStatus;
    }
}