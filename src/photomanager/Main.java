package photomanager;

public class Main {
    public static void main(String[] args) {
        // Создаём объекты через конструкторы
        Camera mainCam = new Camera("Sony", "A7 II", "Sony E", true);
        Camera backupCam = new Camera("Canon", "EOS 80D", "Canon EF", false);

        Lens portraitLens = new Lens("Canon", "EF", "Canon EF", 85, 1.8);
        Lens wideLens = new Lens("Canon", "EF L", "Canon EF", 17, 4.0);

        // Проверяем работу полиморфизма и метода toString()
        System.out.println(mainCam);
        System.out.println(backupCam);
        System.out.println(portraitLens);
        System.out.println(wideLens);
    }
}