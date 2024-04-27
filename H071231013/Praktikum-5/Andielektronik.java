
// mengimpor kelas-kelas yang diperlukan dari paket Java, yaitu AL, List, dan Scanner. AL digunakan untuk menyimpan daftar produk.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Product {
    protected String brand;
    protected int serialNumber;
    protected double price;

    public Product(String brand, int serialNumber, double price) {
        this.brand = brand;
        this.serialNumber = serialNumber;
        this.price = price;
    }

    public abstract void displayInfo();
} // Kelas abstrak Product mendefinisikan atribut umum dari sebuah produk, seperti
  // merek, nomor seri, dan harga.
  // Kelas ini juga memiliki metode abstrak displayInfo()yang akan
  // diimplementasikan oleh kelas turunannya.

class Smartphone extends Product {
    private double screenSize;
    private int storageCapacity;
    // Kelas Smartphone merupakan turunan dari kelas Productdan memiliki atribut
    // tambahan yaitu ukuran layar dan kapasitas penyimpanan.

    // deklarasi konstruktor untuk kelas Smartphone. Konstruktor ini menerima lima
    // parameter.
    public Smartphone(String brand, int serialNumber, double price, double screenSize, int storageCapacity) {
        super(brand, serialNumber, price); // memanggil konstruktor dari kelas induk Product dengan menggunakan super
                                           // dan meneruskan nilai
        this.screenSize = screenSize; // menginisialisasi atribut screenSize dari objek Smartphone dengan nilai yang
                                      // diterima dari
        // parameter screenSize.
        this.storageCapacity = storageCapacity; // menginisialisasi atribut storageCapacity dari objek Smartphone dengan
                                                // nilai yang diterima
        // dari parameter storageCapacity.
    }

    @Override // // untuk menggantikan metode dengan nama yang sama dari kelas induk (
              // Product).
    public void displayInfo() { // metode displayInfo() yang bersifat publik (dapat diakses dari mana saja) dan
                                // tidak mengembalikan nilai (void).
        System.out.println("Brand: " + brand);
        System.out.println("Serial Number: " + serialNumber);
        System.out.println("Price: $" + price);
        System.out.println("Screen Size (inches): " + screenSize);
        System.out.println("Storage Capacity (GB): " + storageCapacity);
    }
}

class Laptop extends Product {
    private String processorType;
    private int ramSize;
    // Kelas Laptop juga merupakan turunan dari kelas Productdan memiliki atribut
    // tambahan yaitu tipe prosesor dan ukuran RAM.

    // deklarasi konstruktor untuk kelas laptop. Konstruktor ini menerima lima
    // parameter.
    public Laptop(String brand, int serialNumber, double price, String processorType, int ramSize) {
        super(brand, serialNumber, price);
        this.processorType = processorType;
        this.ramSize = ramSize;
    }

    @Override // untuk menggantikan metode dengan nama yang sama dari kelas induk ( Product).
    public void displayInfo() { // metode displayInfo() yang bersifat publik (dapat diakses dari mana saja) dan
                                // tidak mengembalikan nilai (void).
        System.out.println("Brand: " + brand);
        System.out.println("Serial Number: " + serialNumber);
        System.out.println("Price: $" + price);
        System.out.println("Processor Type: " + processorType);
        System.out.println("RAM Size (GB): " + ramSize);
    }
}

class Camera extends Product {
    private int resolution;
    private String lensType;
    // Kelas Camera juga merupakan turunan dari kelas Product dan memiliki atribut
    // tambahan yaitu resolusi dan tipe lensa.

    // deklarasi konstruktor untuk kelas Camera. Konstruktor ini menerima lima
    // parameter.
    public Camera(String brand, int serialNumber, double price, int resolution, String lensType) {
        super(brand, serialNumber, price);
        this.resolution = resolution;
        this.lensType = lensType;
    }

    @Override // untuk menggantikan metode dengan nama yang sama dari kelas induk ( Product).
    public void displayInfo() { // metod displayInfo() yang bersifat publik (dapat diakses dari mana saja)
                                // dan tidak mengembalikan nilai (void).
        System.out.println("Brand: " + brand);
        System.out.println("Serial Number: " + serialNumber);
        System.out.println("Price: $" + price);
        System.out.println("Resolution (MP): " + resolution);
        System.out.println("Lens Type: " + lensType);
    }
}

public class Andielektronik {
    private static List<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    // Kelas Andi elektronik merupakan kelas utama yang berisi program logika.
    // Kelas ini memiliki daftar produk yang disimpan dalam ArrayList dan sebuah
    // objek Scanneruntuk input bacaan dari pengguna.

    public static void main(String[] args) {
        boolean exit = false; // untuk mengontrol berulangnya loop utama program.
        while (!exit) { // perulangan while yang akan terus berjalan selama nilai exit adalah
                        // false.
            displayMenu();
            int choice = scanner.nextInt(); // Membaca pilihan pengguna dari input dan menyimpannya dalam variabel
                                            // choice.
            scanner.nextLine(); // membersihkan karakter newline dari buffer input.

            switch (choice) { // akan mengeksekusi kode sesuai dengan pilihan pengguna.
                case 1: // Memanggil metod addProduct() untuk menambahkan produk baru.
                    addProduct();
                    break;
                case 2: // Memanggil metod displayAllProducts()untuk menampilkan semua produk yang
                        // tersedia.
                    displayAllProducts();
                    break;
                case 3: // Memanggil metod buyProduct() untuk membeli produk berdasarkan nomor seri.
                    buyProduct();
                    break;
                case 4: // Mengubah nilai exitmen jadi true keluar dari loop, dan mencetak pesan "Terima
                        // sampai jumpa"
                    exit = true;
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                    break;
                default: // Mencetak pesan "Pilihan tidak valid. Silakan coba lagi." jika pilihan
                         // pengguna tidak valid.
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void displayMenu() { // metod displayInfo() yang bersifat publik (dapat diakses dari mana saja) dan
                                        // tidak mengembalikan nilai (void).
        System.out.println("Menu:");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Tampilkan Semua Produk");
        System.out.println("3. Beli Produk");
        System.out.println("4. Keluar");
        System.out.print(">>> Pilih menu (1-4): ");
    }

    private static void addProduct() { // metod addProduct()yang bersifat private(hanya dapat diakses dalam
                                       // kelas Andielektronik)

        System.out.print("Masukkan nama produk: ");
        String brand = scanner.nextLine();
        System.out.print("Masukkan nomor seri: ");
        int serialNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Masukkan harga: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Pilih tipe produk:");
        System.out.println("1. Smartphone");
        System.out.println("2. Laptop");
        System.out.println("3. Camera");
        System.out.print(">>> Pilih tipe produk (1-3): ");
        int type = scanner.nextInt(); // membaca input pengguna (yaitu angka yang mewakili tipe produk) dan
                                      // menyimpannya dalam variabel type.
        scanner.nextLine();

        switch (type) { // untuk memilih blok kode yang akan dieksekusi berdasarkan nilai dari variabel
                        // type.
            case 1:
                System.out.print("Masukkan ukuran layar (inci): ");
                double screenSize = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                int storageCapacity = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                products.add(new Smartphone(brand, serialNumber, price, screenSize, storageCapacity));
                break;
            case 2:
                System.out.print("Masukkan tipe prosesor: ");
                String processorType = scanner.nextLine();
                System.out.print("Masukkan ukuran RAM (GB): ");
                int ramSize = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                products.add(new Laptop(brand, serialNumber, price, processorType, ramSize));
                break;
            case 3:
                System.out.print("Masukkan resolusi (MP): ");
                int resolution = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                System.out.print("Masukkan tipe lensa: ");
                String lensType = scanner.nextLine();
                products.add(new Camera(brand, serialNumber, price, resolution, lensType));
                break;
            default:
                System.out.println("Tipe produk tidak valid.");
        }
    }

    private static void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Tidak ada produk yang tersedia.");
        } else {
            for (Product product : products) {
                product.displayInfo();
                System.out.println();
            }
        }
    }

    // metode buyProduct()yang bersifat private(hanya dapat diakses dalam kelas
    // Andielektronik) dan static
    private static void buyProduct() { // (dapat dipanggil tanpa membuat instance dari kelas). Metode ini tidak
                                       // mengembalikan nilai (void).
        System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
        int serialNumber = scanner.nextInt(); // membaca input dari pengguna dan menyimpannya dalam variabel
                                              // serialNumberdengan tipe data int.
        scanner.nextLine(); // Consume newline character

        boolean found = false; // untuk melacak apakah produk dengan nomor seri yang diinputkan ditemukan atau
                               // tidak.
        for (Product product : products) { // perulangan for-eachyang akan memeriksa setiap objek Productdalam daftar
                                           // products.
            if (product.serialNumber == serialNumber) { // memeriksa apakah serialNumber dari objek tersebut sama dengan
                                                        // serialNumberyang diinputkan
                System.out.println("Anda telah membeli produk:");
                product.displayInfo();
                found = true;
                break;
            }
        }
        // Jika setelah perulangan for-each selesai, nilai found masih false, berarti
        // produk dengan nomor seri yang diinputkan
        // tidak ditemukan dalam daftar produk.
        if (!found) {
            System.out.println("Nomor seri produk tersebut tidak ditemukan.");
        }
    }
}