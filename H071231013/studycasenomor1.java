// Interface Dog
interface Dog {
    int position = 0;
    int averageLength = 0;

    void move();

    void describe();
}
// Interface mendefinisikan sekumpulan metode yang harus diimplementasikan oleh
// setiap kelas yang mengimplementasikan interface ini.
// Dog memiliki dua variabel position dan averageLength dengan nilai default 0,
// serta dua metode move() dan describe()
// yang tidak memiliki implementasi di dalam interface.

// Kelas Pitbull yang mengimplementasikan interface Dog
// class Pitbull implements Dog {
// private int position = 0; // Tambahkan atribut position di dalam kelas

// @Override
// public void move() {
// position += 3;
// System.out.println("Pitbull berpindah 3 langkah. Posisi sekarang: " +
// position);
// }

// @Override
// public void describe() {
// System.out.println("Deskripsi Pitbull: Ras anjing yang kuat dan berotot.");
// }
// }

// Pitbull adalah kelas yang mengimplementasikan interface Dog. Kelas ini
// memiliki atribut position yang diinisialisasi dengan nilai 0.
// Kelas ini juga mengimplementasikan metode move() dan describe() sesuai dengan
// kontrak yang didefinisikan di dalam interface Dog.
// Metode move() akan menambahkan nilai position dengan 3 dan mencetak pesan ke
// konsol.
// Metode describe() mencetak deskripsi tentang ras anjing Pitbull.

// Kelas Siberian Husky yang mengimplementasikan interface Dog
class SiberianHusky implements Dog {
    private int position = 0; // Tambahkan atribut position di dalam kelas

    @Override
    public void move() {
        position += 2;
        System.out.println("Siberian Husky berpindah 2 langkah. Posisi sekarang: " + position);
    }

    @Override
    public void describe() {
        System.out.println("Deskripsi Siberian Husky: Ras anjing yang energik dan loyal.");
    }
}
// mengikuti pola yang sama seperti kelas pitbull, hanya dengan implementasi
// yang berbeda untuk metode move() dan describe().

// Kelas Bulldog yang mengimplementasikan interface Dog
class Bulldog implements Dog {
    private int position = 0; // Tambahkan atribut position di dalam kelas

    @Override
    public void move() {
        position += 1;
        System.out.println("Bulldog berpindah 1 langkah. Posisi sekarang: " + position);
    }

    @Override
    public void describe() {
        System.out.println("Deskripsi Bulldog: Ras anjing yang setia dan tenang.");
    }
}
// mengikuti pola yang sama seperti kelas siberianhusky, hanya dengan
// implementasi yang berbeda untuk metode move() dan describe().

// Kelas German Shepherd yang mengimplementasikan interface Dog
class GermanShepherd implements Dog {
    private int position = 0; // Tambahkan atribut position di dalam kelas

    @Override
    public void move() {
        position += 3;
        System.out.println("German Shepherd berpindah 3 langkah. Posisi sekarang: " + position);
    }

    @Override
    public void describe() {
        System.out.println("Deskripsi German Shepherd: Ras anjing yang cerdas dan tangguh.");
    }
}
// mengikuti pola yang sama seperti kelas bulldog, hanya dengan implementasi
// yang berbeda untuk metode move() dan describe().

// Kelas Smartphone
class Smartphone {
    int price;
    String brand;

    void move() {
        System.out.println("Smartphone berpindah.");
    }
}
// Smartphone adalah kelas yang memiliki dua atribut price dan brand, serta
// metode move() yang mencetak pesan ke konsol.

// Kelas Car
abstract class Car {
    int totalForwardGear;
    String color;
    int maxSpeed;

    abstract void move();
}
// Car adalah kelas abstrak yang memiliki tiga atribut totalForwardGear, color,
// dan maxSpeed, serta metode abstrak move()
// yang tidak memiliki implementasi di dalam kelas ini.

// Kelas MobilSedangBerakselerasi yang meng-extend kelas Car
class MobilSedangBerakselerasi extends Car {
    @Override
    void move() {
        System.out.println("Mobil sedang berakselerasi!");
    }
}
// MobilSedangBerakselerasi adalah kelas yang meng-extend (mewarisi) kelas Car.
// Kelas ini mengimplementasikan metode move() yang telah dideklarasikan sebagai
// metode abstrak di dalam kelas Car.

// Ini adalah kelas utama studycasenomor1 yang berisi metode main(). Di dalam
// metode main(), program melakukan hal-hal berikut:
// Membuat instance dari kelas Smartphone dengan nama smartphone.
// Membuat instance dari kelas MobilSedangBerakselerasi (yang meng-extend Car)
// dengan nama car.
// Membuat instance dari empat kelas yang mengimplementasikan interface Dog:
// Pitbull, SiberianHusky, Bulldog, dan GermanShepherd.
// Memanggil metode move() dan describe() pada setiap instance dari kelas-kelas
// yang mengimplementasikan Dog.
// Memanggil metode move() pada instance smartphone dan car.
public class studycasenomor1 {
    public static void main(String[] args) {
        // Instance dari Smartphone
        Smartphone smartphone = new Smartphone();

        // Instance dari Car
        Car car = new MobilSedangBerakselerasi();

        // Instance dari ras-ras Dog
        // Pitbull pitbull = new Pitbull();
        SiberianHusky husky = new SiberianHusky();
        Bulldog bulldog = new Bulldog();
        GermanShepherd shepherd = new GermanShepherd();

        // Memanggil method move() dan describe() pada instance Dog
        // pitbull.move();
        // pitbull.describe();

        husky.move();
        husky.describe();

        bulldog.move();
        bulldog.describe();

        shepherd.move();
        shepherd.describe();

        // Memanggil method move() pada instance Smartphone dan Car
        smartphone.move();
        car.move();
    }
}