package photomanager;

public abstract class Equipment {
    private String brand;
    private String model;
    private String mount;

    public Equipment(String brand, String model, String mount) {
        this.brand = brand;
        this.model = model;
        this.mount = mount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMount() {
        return mount;
    }

    public void setMount(String mount) {
        this.mount = mount;
    }

    @Override
    public String toString() {
        return brand + " " + model + " (Mount: " + mount + ")";
    }
}