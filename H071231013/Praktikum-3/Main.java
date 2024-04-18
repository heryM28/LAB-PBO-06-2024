public class Main {
    public static void main(String[] args) {
        // objek HotWheels dibuat dengan memanggil konstruktor HotWheels(String name,
        // double speed, double cash).
        HotWheels mercedesDenz = new HotWheels("Mercedes-Denz", 4, 20000);

        HotWheels ferharri = new HotWheels("Ferharri", 4, 50000.0);

        // Nilai atribut name, speed, dan cash dari objek ferharri diubah menggunakan
        // metode setter.
        ferharri.setName("Ferharri");
        ferharri.setSpeed(4);
        ferharri.setCash(50000);

        // Metode showSpec() dipanggil untuk mencetak spesifikasi objek mercedesDenz dan
        // ferharri.
        System.out.println();
        mercedesDenz.showSpec();
        ferharri.showSpec();

        printBarriers(); // mencetak garis pembatas.
        // Metode upgrade(int budget) dipanggil untuk meningkatkan kecepatan objek
        // mercedesDenz dan ferharri dengan budget 50000.
        mercedesDenz.upgrade(50000);
        printBarriers();
        ferharri.upgrade(50000);
        printBarriers();

        System.out.println();
        ferharri.showSpec();

        printBarriers();
        // Metode raceTo(HotWheels enemy) dipanggil untuk melakukan pertandingan antara
        // objek mercedesDenz dan ferharri.
        mercedesDenz.raceTo(ferharri); // corrected method call
        printBarriers();
        ferharri.raceTo(mercedesDenz); // corrected method call
        printBarriers();

        // Metode showSpec() dipanggil untuk mencetak spesifikasi terakhir dari objek
        // mercedesDenz dan ferharri.
        System.out.println();
        mercedesDenz.showSpec();
        ferharri.showSpec();
    }

    // Metode printBarriers() digunakan untuk mencetak garis pembatas yang terdiri
    // dari karakter sama dengan (=) sebanyak 32 kali.
    public static void printBarriers() {
        System.out.println("================================");
    }

}