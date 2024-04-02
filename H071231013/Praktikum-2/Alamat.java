// nomor 4
import java.util.Scanner; // Impor kelas Scanner

class Alamat {
    // Mendeklarasikan variabel instance jalan dan kota yang merepresentasikan alamat.
    String jalan;
    String kota;

    Alamat() { // Konstruktor Alamat tanpa parameter.
    }

    // Method untuk mendapatkan representasi string dari alamat
    public String toString() {
        return jalan + ", " + kota;
    }
}

class Mahasiswa { // Mendeklarasikan variabel instance nama, nim, dan objek alamat dari kelas Alamat.
    String nama;
    String nim;
    Alamat alamat;

    // Constructor tanpa parameter
    Mahasiswa() {
    }

    // Method untuk mendapatkan nama mahasiswa
    public String getName() {
        return nama;
    }

    // Method untuk mendapatkan NIM mahasiswa
    public String getNim() {
        return nim;
    }

    // Method untuk mendapatkan alamat mahasiswa
    public String getAlamat() {
        // Menggunakan method toString dari class Alamat
        return alamat.toString();
    }
}

class Identitas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner

        // Meminta input nama, NIM, jalan, dan kota dari pengguna menggunakan scanner.nextLine().
        System.out.println("Masukkan nama:");
        String nama = scanner.nextLine();

        System.out.println("Masukkan NIM:");
        String nim = scanner.nextLine();

        System.out.println("Masukkan jalan:");
        String jalan = scanner.nextLine();

        System.out.println("Masukkan kota:");
        String kota = scanner.nextLine();

        // Membuat objek alamat dari kelas Alamat dan menginisialisasi nilainya dengan input jalan dan kota.
        Alamat alamat = new Alamat();
        alamat.jalan = jalan;
        alamat.kota = kota;

        // Membuat objek mahasiswa dari kelas Mahasiswa dan menginisialisasi nama, NIM, dan alamat dengan nilai yang telah diinputkan.
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.nama = nama;
        mahasiswa.nim = nim;
        mahasiswa.alamat = alamat;

        // Menampilkan informasi 
        System.out.println("Nama: " + mahasiswa.getName());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}