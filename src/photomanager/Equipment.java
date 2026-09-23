package photomanager;

public abstract class Equipment {
    private String brand;
    private String model;
    private String mount; // Lens mount, e.g., "Sony E" or "Canon EF"

    public Equipment(String brand, String model, String mount) {
        this.brand = brand;
        this.model = model;
        this.mount = mount;
    }

    public String getMount() {
        return mount;
    }

    @Override
    public String toString() {
        return brand + " " + model + " (Mount: " + mount + ")";
    }
}