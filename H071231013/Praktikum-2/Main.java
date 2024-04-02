// Nomor 3
class Cuboid {
    // Mendeklarasikan variabel instance
    double height;
    double width;
    double length;

    // Konstruktor untuk menginisialisasi dimensi balok
    Cuboid(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    // Method untuk menghitung dan mengembalikan volume kubus dengan rumus
    double getVolume() {
        return height * width * length;
    }
}

public class Main {
    public static void main(String[] args) {
        // Membuat objek balok dengan dimensi yang diperlukan untuk mendapatkan volume 4500.00
        // Misalnya, menggunakan dimensi: tinggi=10, lebar=15, panjang=30
        Cuboid cuboid = new Cuboid(10, 15, 30); // Lengkapi

        // Menampilkan volume balok dengan dua angka di belakang koma
        System.out.printf("Volume: %.2f", cuboid.getVolume());
    }
}