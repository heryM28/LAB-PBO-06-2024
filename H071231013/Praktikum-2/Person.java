// Nomor 1
public class Person {
    // Deklarasi variabel
    String name;
    int age;
    boolean isMale;

    // Constructor default
    public Person() {
    }

    // Constructor dengan parameter
    public Person(String name, int age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    // Metode untuk mengatur nama
    public void setName(String name) {
        this.name = name;
    }

    // Metode untuk mendapatkan nama
    public String getName() {
        return this.name;
    }

    // Metode untuk mengatur usia
    public void setAge(int age) {
        this.age = age;
    }

    // Metode untuk mendapatkan usia
    public int getAge() {
        return this.age;
    }

    // Metode untuk mengatur jenis kelamin
    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }

    // Metode untuk mendapatkan jenis kelamin dalam bentuk String
    public String getGender() {
        return isMale ? "Male" : "Female";
    }

    // Metode utama untuk menjalankan program
    public static void main(String[] args) {
        // Membuat objek Person
        Person person = new Person("Hery Mangalik", 18, true);

        // Menampilkan informasi person
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Gender: " + person.getGender());
    }
}