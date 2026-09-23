package photomanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Equipment> inventory = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Photo Gear Manager ---");
            System.out.println("1. Add Camera");
            System.out.println("2. Add Lens");
            System.out.println("3. Show Inventory");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline buffer

            switch (choice) {
                case 1:
                    System.out.print("Brand (e.g., Sony): ");
                    String camBrand = scanner.nextLine();

                    System.out.print("Model (e.g., A7 II): ");
                    String camModel = scanner.nextLine();

                    System.out.print("Mount (e.g., Sony E): ");
                    String camMount = scanner.nextLine();

                    System.out.print("Is Full Frame? (true/false): ");
                    boolean isFullFrame = scanner.nextBoolean();
                    scanner.nextLine(); // Clear buffer

                    Camera newCamera = new Camera(camBrand, camModel, camMount, isFullFrame);
                    inventory.add(newCamera);
                    System.out.println("=> Camera added successfully!");
                    break;

                case 2:
                    System.out.print("Brand (e.g., Canon): ");
                    String lensBrand = scanner.nextLine();

                    System.out.print("Model (e.g., EF USM): ");
                    String lensModel = scanner.nextLine();

                    System.out.print("Mount (e.g., Canon EF): ");
                    String lensMount = scanner.nextLine();

                    System.out.print("Focal Length (mm, e.g., 85): ");
                    int focalLength = scanner.nextInt();

                    System.out.print("Max Aperture (f-stop, e.g., 1.8): ");
                    double aperture = scanner.nextDouble();
                    scanner.nextLine(); // Clear buffer

                    Lens newLens = new Lens(lensBrand, lensModel, lensMount, focalLength, aperture);
                    inventory.add(newLens);
                    System.out.println("=> Lens added successfully!");
                    break;

                case 3:
                    System.out.println("\n--- Current Inventory ---");
                    if (inventory.isEmpty()) {
                        System.out.println("Inventory is empty.");
                    } else {
                        for (Equipment item : inventory) {
                            System.out.println(item);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting application...");
                    scanner.close();
                    return;

                default:
                    System.out.println("=> Unknown command. Please try again.");
            }
        }
    }
}