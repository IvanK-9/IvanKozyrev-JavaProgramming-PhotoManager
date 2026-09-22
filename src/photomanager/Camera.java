package photomanager;

public class Camera extends Equipment {
    private boolean isFullFrame;

    public Camera(String brand, String model, String mount, boolean isFullFrame) {
        super(brand, model, mount); // Вызов конструктора родительского класса
        this.isFullFrame = isFullFrame;
    }

    @Override
    public String toString() {
        String sensor = isFullFrame ? "Full Frame" : "Crop";
        return "[Камера] " + super.toString() + " - " + sensor;
    }
}