import java.util.Scanner; // mengimpor kelas Scan dari paket ju

public class ArmyElite {
    String name; // atribut
    Weapon weapon = new Weapon(); // atribut
    int health = 100; // nilai default 100
    double speed; // atribut

    // disini ada tujuh konstruktor untuk ae. Setiap konstruktor menerima parameter
    // yang berbeda
    // dan menginisialisasi atribut sesuai dengan parameter yang diberikan.
    public ArmyElite() {
    }

    public ArmyElite(String name) {
        this.name = name;
    }

    public ArmyElite(String name, String weaponType) {
        this.name = name;
        this.weapon.type = weaponType;
    }

    public ArmyElite(String name, String weaponType, int weaponDamage) {
        this.name = name;
        this.weapon.type = weaponType;
        this.weapon.damage = weaponDamage;
    }

    public ArmyElite(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    public ArmyElite(String name, String weaponType, int weaponDamage, double speed) {
        this.name = name;
        this.weapon.type = weaponType;
        this.weapon.damage = weaponDamage;
        this.speed = speed;
    }

    public ArmyElite(String name, String weaponType, int weaponDamage, int health, double speed) {
        this.name = name;
        this.weapon.type = weaponType;
        this.weapon.damage = weaponDamage;
        this.health = health;
        this.speed = speed;
    }

    // mencetak informasi status tentang objek AE,seperti nama, tipe senjata,
    // kerusakan senjata, kesehatan, dan kecepatan.
    public void checkStatus() {
        System.out.println("===== Army Elite's Status =====");
        System.out.println("Name : " + this.getName());
        System.out.println("Weapon Type : " + this.getWeapon().getType());
        System.out.println("Weapon Damage : " + this.getWeapon().getDamage());
        System.out.println("Health : " + this.getHealth());
        System.out.println("Speed : " + this.getSpeed());
    }

    // mengatur kecepatan objek AE dengan nilai location yang diberikan dan mencetak
    // pesan yang menunjukkan bahwa objek tersebut sedang bergerak ke lokasi
    // tersebut.
    public void moveToLocation(double location) {
        this.setSpeed(location);
        System.out.printf("%s is moving to location: %.1f \n", this.getName(), location);
    }

    // memperbarui tipe senjata dan kerusakan senjata objek AE dengan nilai yang
    // diberikan sebagai parameter dan mencetak pesan yang menunjukkan bahwa senjata
    // telah diperbarui.
    public void upgradeWeapon(String type, int damage) {
        this.weapon.type = type;
        this.weapon.damage = damage;
        System.out.printf("%s has upgraded the weapon to %s with %d damage \n", this.getName(), type, damage);
    }

    // Metode ini memungkinkan objek ArmyElite untuk menyerang objek ArmyElite lain
    // yang diberikan sebagai parameter. Jika kecepatan kedua objek sama, mereka
    // saling menyerang satu sama lain dengan mengurangi kesehatan masing-masing
    // sesuai dengan kerusakan senjata lawannya. Jika kesehatan musuh mencapai 0
    // atau kurang, metode akan mencetak pesan bahwa musuh telah kalah. Jika
    // kecepatan mereka berbeda, metode akan mencetak pesan bahwa mereka tidak dapat
    // menyerang karena berada di lokasi yang berbeda.
    public void attackEnemy(ArmyElite enemy) {
        if (this.getSpeed() == enemy.getSpeed()) {
            enemy.health -= this.getWeapon().getDamage();
            this.health -= enemy.getWeapon().getDamage();
            if (enemy.getHealth() <= 0) {
                System.out.printf("%s has lost \n", enemy.getName());
            }
            System.out.printf("%s attack %s ... \n", this.getName(), enemy.getName());
        } else {
            System.out.printf("%s and %s are in different locations. Can't attack \n", this.getName(), enemy.getName());
        }
    }

    // ini digunakan untuk mengakses dan mengubah nilai atribut objek
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama elite 1: ");
        String nama1 = scanner.nextLine();
        System.out.print("Masukkan tipe senjata elite 1: ");
        String weaponType1 = scanner.nextLine();
        System.out.print("Masukkan damage senjata elite 1: ");
        int weaponDamage1 = scanner.nextInt();
        System.out.print("Masukkan kecepatan elite 1: ");
        double speed1 = scanner.nextDouble();
        scanner.nextLine(); // Membersihkan baris baru setelah membaca double

        System.out.print("Masukkan nama elite 2: ");
        String nama2 = scanner.nextLine();
        System.out.print("Masukkan tipe senjata elite 2: ");
        String weaponType2 = scanner.nextLine();
        System.out.print("Masukkan damage senjata elite 2: ");
        int weaponDamage2 = scanner.nextInt();
        System.out.print("Masukkan kecepatan elite 2: ");
        double speed2 = scanner.nextDouble();
        scanner.nextLine(); // Membersihkan baris baru setelah membaca double

        // Membuat objek baru elite1 dari kelas ArmyElite dengan menggunakan konstruktor
        // yang menerima parameter nama1, weaponType1, weaponDamage1, dan speed1.
        ArmyElite elite1 = new ArmyElite(nama1, weaponType1, weaponDamage1, speed1);
        ArmyElite elite2 = new ArmyElite(nama2, weaponType2, weaponDamage2, speed2);

        // mencetak informasi status tentang objek tersebut seperti nama, tipe senjata,
        // kerusakan senjata, kesehatan, dan kecepatan.
        elite1.checkStatus();
        elite2.checkStatus();

        // mengatur kecepatan objek elite1 dengan nilai speed1 dan mencetak pesan bahwa
        // objek tersebut sedang bergerak ke lokasi tersebut.
        elite1.moveToLocation(speed1);
        elite2.moveToLocation(speed2);

        System.out.print("Masukkan tipe senjata baru untuk elite 1: ");
        String newWeaponType = scanner.nextLine();
        System.out.print("Masukkan damage senjata baru untuk elite 1: ");
        int newWeaponDamage = scanner.nextInt(); // Membaca input dari pengguna berupa nilai integer yang akan digunakan
                                                 // sebagai damage senjata baru untuk objek elite1.

        elite1.upgradeWeapon(newWeaponType, newWeaponDamage);
        // Metode ini akan memperbarui tipe senjata dan damage senjata pada objek elite1
        // dengan nilai-nilai yang diberikan.
        elite1.attackEnemy(elite2); // memeriksa apakah kecepatan elite1 dan elite2 sama. Jika sama, maka elite1
                                    // akan menyerang elite2 dan mengurangi health masing-masing sesuai dengan
                                    // damage senjata lawannya.

        // mencetak informasi status tentang objek tersebut, seperti nama, tipe senjata,
        // damage senjata, health, dan kecepatan.
        elite1.checkStatus();
        elite2.checkStatus();
    }
}

// Kelas Weapon memiliki dua atribut: type (String) dan damage (integer), serta
// metode getter dan setter untuk mengakses dan mengubah nilai atribut tersebut.
class Weapon {
    String type;
    int damage;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}