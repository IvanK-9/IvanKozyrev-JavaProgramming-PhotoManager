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
            System.out.println("3. Show All Inventory");
            System.out.println("4. Show Only Cameras");
            System.out.println("5. Show Only Lenses");
            System.out.println("6. Search Equipment by Name");
            System.out.println("7. Edit Equipment");
            System.out.println("8. Remove Equipment");
            System.out.println("0. Exit");

            int choice = readInt(scanner, "Your choice: ");

            switch (choice) {
                case 1:
                    System.out.print("Brand (e.g., Sony): ");
                    String camBrand = scanner.nextLine().trim();

                    System.out.print("Model (e.g., A7 II): ");
                    String camModel = scanner.nextLine().trim();

                    System.out.print("Mount (e.g., Sony E): ");
                    String camMount = scanner.nextLine().trim();

                    boolean isFullFrame = readBoolean(scanner, "Is Full Frame? (true/false): ");

                    inventory.add(new Camera(camBrand, camModel, camMount, isFullFrame));
                    System.out.println("=> Camera added successfully!");
                    break;

                case 2:
                    System.out.print("Brand (e.g., Canon): ");
                    String lensBrand = scanner.nextLine().trim();

                    System.out.print("Model (e.g., EF USM): ");
                    String lensModel = scanner.nextLine().trim();

                    System.out.print("Mount (e.g., Canon EF): ");
                    String lensMount = scanner.nextLine().trim();

                    int focalLength = readInt(scanner, "Focal Length (mm, e.g., 85): ");
                    double aperture = readDouble(scanner, "Max Aperture (f-stop, e.g., 1.8): ");

                    inventory.add(new Lens(lensBrand, lensModel, lensMount, focalLength, aperture));
                    System.out.println("=> Lens added successfully!");
                    break;

                case 3:
                    printInventory(inventory, "Current Inventory");
                    break;

                case 4:
                    System.out.println("\n--- Cameras Only ---");
                    boolean hasCameras = false;
                    for (Equipment item : inventory) {
                        if (item instanceof Camera) {
                            System.out.println(item);
                            hasCameras = true;
                        }
                    }
                    if (!hasCameras) {
                        System.out.println("No cameras found.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- Lenses Only ---");
                    boolean hasLenses = false;
                    for (Equipment item : inventory) {
                        if (item instanceof Lens) {
                            System.out.println(item);
                            hasLenses = true;
                        }
                    }
                    if (!hasLenses) {
                        System.out.println("No lenses found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter search keyword (brand or model): ");
                    String query = scanner.nextLine().trim().toLowerCase();
                    System.out.println("\n--- Search Results ---");
                    boolean found = false;
                    for (Equipment item : inventory) {
                        if (item.getBrand().toLowerCase().contains(query) ||
                                item.getModel().toLowerCase().contains(query)) {
                            System.out.println(item);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No matching equipment found.");
                    }
                    break;

                case 7:
                    if (inventory.isEmpty()) {
                        System.out.println("Inventory is empty. Nothing to edit.");
                        break;
                    }
                    printIndexedInventory(inventory);
                    int editIndex = readInt(scanner, "Select index to edit: ") - 1;
                    if (editIndex >= 0 && editIndex < inventory.size()) {
                        Equipment item = inventory.get(editIndex);

                        System.out.print("New Brand (leave empty to keep '" + item.getBrand() + "'): ");
                        String newBrand = scanner.nextLine().trim();
                        if (!newBrand.isEmpty()) {
                            item.setBrand(newBrand);
                        }

                        System.out.print("New Model (leave empty to keep '" + item.getModel() + "'): ");
                        String newModel = scanner.nextLine().trim();
                        if (!newModel.isEmpty()) {
                            item.setModel(newModel);
                        }

                        System.out.print("New Mount (leave empty to keep '" + item.getMount() + "'): ");
                        String newMount = scanner.nextLine().trim();
                        if (!newMount.isEmpty()) {
                            item.setMount(newMount);
                        }

                        System.out.println("=> Equipment updated successfully!");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 8:
                    if (inventory.isEmpty()) {
                        System.out.println("Inventory is empty. Nothing to remove.");
                        break;
                    }
                    printIndexedInventory(inventory);
                    int removeIndex = readInt(scanner, "Select index to remove: ") - 1;
                    if (removeIndex >= 0 && removeIndex < inventory.size()) {
                        Equipment removed = inventory.remove(removeIndex);
                        System.out.println("=> Removed: " + removed);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting application...");
                    scanner.close();
                    return;

                default:
                    System.out.println("=> Unknown option. Please choose between 0 and 8.");
            }
        }
    }

    private static void printInventory(List<Equipment> inventory, String title) {
        System.out.println("\n--- " + title + " ---");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Equipment item : inventory) {
                System.out.println(item);
            }
        }
    }

    private static void printIndexedInventory(List<Equipment> inventory) {
        System.out.println("\n--- Equipment List ---");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i));
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid whole number.");
            }
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number (e.g., 1.8).");
            }
        }
    }

    private static boolean readBoolean(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("yes") || input.equals("y")) {
                return true;
            } else if (input.equals("false") || input.equals("no") || input.equals("n")) {
                return false;
            }
            System.out.println("Invalid input. Please enter 'true' or 'false'.");
        }
    }
}