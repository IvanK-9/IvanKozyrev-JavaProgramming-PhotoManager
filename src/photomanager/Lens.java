package photomanager;

public class Lens extends Equipment {
    private int focalLength;
    private double aperture;

    // ... ваш конструктор и методы ...

    public Lens(String brand, String model, String mount, int focalLength, double aperture) {
        super(brand, model, mount);
        this.focalLength = focalLength;
        this.aperture = aperture;
    }

    @Override
    public String toString() {
        return "[Объектив] " + super.toString() + " -> " + focalLength + "mm f/" + aperture;
    }
}