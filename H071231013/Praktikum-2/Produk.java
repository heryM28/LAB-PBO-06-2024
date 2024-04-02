// Nomor 2
class Barang {
    // Deklarasi variabel instance
     String id;
     String nama;
     int stok;
     double harga;

    // Constructor untuk inisialisasi objek Produk
    Barang(String id, String nama, int stok, double harga) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    // Getter untuk ID
    public String getId() {
        return id; // Mengembalikan nilai id.
    }

    // Getter untuk nama
    public String getNama() {
        return nama; // Mengembalikan nilai nama.
    }

    // Getter untuk stok
    public int getStok() {
        return stok; // Mengembalikan nilai stok.
    }

    // Getter untuk harga
    public double getHarga() {
        return harga; // Mengembalikan nilai harga.
    }

    // Method untuk menampilkan semua data produk
    public void tampilkanData() { // Method untuk menampilkan data barang, mencetak ID, nama, stok, dan harga ke konsol.
        System.out.println("ID Produk: " + id);
        System.out.println("Nama Produk: " + nama);
        System.out.println("Stok: " + stok);
        System.out.println("Harga: Rp" + harga);
    }

    // Method untuk mengecek ketersediaan produk
    public boolean cekKetersediaan() { // Method untuk memeriksa ketersediaan barang. Mengembalikan true jika stok lebih dari 0.
        return stok > 0;
    }
}


public class Produk {
    public static void main(String[] args) { // membuat objek Barang, menampilkan data produk, dan memeriksa ketersediaan barang.
        Barang produk1 = new Barang("P001", "Pensil", 100, 2000);
        // Membuat objek produk1 dari kelas Barang dengan parameter yang diberikan.

        // Menampilkan data produk
        produk1.tampilkanData();

        // Mengecek ketersediaan produk di stok
        if (produk1.cekKetersediaan()) {
            System.out.println("Produk tersedia di stok.");
        } else {
            System.out.println("Produk tidak tersedia di stok.");
        }
    }
}