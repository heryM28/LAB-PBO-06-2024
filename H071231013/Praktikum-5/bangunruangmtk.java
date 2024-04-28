class BangunRuang {
    void hitungLuas() {
        System.out.println("Luas belum dihitung");
    }

    void hitungVolume() {
        System.out.println("Volume belum dihitung");
    }
}

class Kubus extends BangunRuang {
    double sisi;

    Kubus(double sisi) {
        this.sisi = sisi;
    }

    void hitungLuas() {
        double luas = 6 * sisi * sisi;
        System.out.println("Luas Kubus: " + luas);
    }

    void hitungVolume() {
        double volume = sisi * sisi * sisi;
        System.out.println("Volume Kubus: " + volume);
    }
}

class Balok extends BangunRuang {
    double panjang, lebar, tinggi;

    Balok(double panjang, double lebar, double tinggi) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    void hitungLuas() {
        double luas = 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
        System.out.println("Luas Balok: " + luas);
    }

    void hitungVolume() {
        double volume = panjang * lebar * tinggi;
        System.out.println("Volume Balok: " + volume);
    }
}

class Bola extends BangunRuang {
    double jariJari;

    Bola(double jariJari) {
        this.jariJari = jariJari;
    }

    void hitungLuas() {
        double luas = 4 * Math.PI * jariJari * jariJari;
        System.out.println("Luas Bola: " + luas);
    }

    void hitungVolume() {
        double volume = (4 * Math.PI * jariJari * jariJari * jariJari) / 3;
        System.out.println("Volume Bola: " + volume);
    }
}

class Tabung extends BangunRuang {
    double jariJari, tinggi;

    Tabung(double jariJari, double tinggi) {
        this.jariJari = jariJari;
        this.tinggi = tinggi;
    }

    void hitungLuas() {
        double luas = 2 * Math.PI * jariJari * (jariJari + tinggi);
        System.out.println("Luas Tabung: " + luas);
    }

    void hitungVolume() {
        double volume = Math.PI * jariJari * jariJari * tinggi;
        System.out.println("Volume Tabung: " + volume);
    }
}

class BangunDatar {
    void hitungLuas() {
        System.out.println("Luas belum dihitung");
    }

    void hitungKeliling() {
        System.out.println("Keliling belum dihitung");
    }
}

class Persegi extends BangunDatar {
    double sisi;

    Persegi(double sisi) {
        this.sisi = sisi;
    }

    void hitungLuas() {
        double luas = sisi * sisi;
        System.out.println("Luas Persegi: " + luas);
    }

    void hitungKeliling() {
        double keliling = 4 * sisi;
        System.out.println("Keliling Persegi: " + keliling);
    }
}

class PersegiPanjang extends BangunDatar {
    double panjang, lebar;

    PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    void hitungLuas() {
        double luas = panjang * lebar;
        System.out.println("Luas Persegi Panjang: " + luas);
    }

    void hitungKeliling() {
        double keliling = 2 * (panjang + lebar);
        System.out.println("Keliling Persegi Panjang: " + keliling);
    }
}

class Lingkaran extends BangunDatar {
    double jariJari;

    Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    void hitungLuas() {
        double luas = Math.PI * jariJari * jariJari;
        System.out.println("Luas Lingkaran: " + luas);
    }

    void hitungKeliling() {
        double keliling = 2 * Math.PI * jariJari;
        System.out.println("Keliling Lingkaran: " + keliling);
    }
}

class Trapesium extends BangunDatar {
    double sisiAtas, sisiBawah, tinggi, sisiMiring1, sisiMiring2;

    Trapesium(double sisiAtas, double sisiBawah, double tinggi, double sisiMiring1, double sisiMiring2) {
        this.sisiAtas = sisiAtas;
        this.sisiBawah = sisiBawah;
        this.tinggi = tinggi;
        this.sisiMiring1 = sisiMiring1;
        this.sisiMiring2 = sisiMiring2;
    }

    void hitungLuas() {
        double luas = 0.5 * (sisiAtas + sisiBawah) * tinggi;
        System.out.println("Luas Trapesium: " + luas);
    }

    void hitungKeliling() {
        double keliling = sisiAtas + sisiBawah + sisiMiring1 + sisiMiring2;
        System.out.println("Keliling Trapesium: " + keliling);
    }
}

public class bangunruangmtk {
    public static void main(String[] args) {
        System.out.println("====== BANGUN RUANG ======");
        System.out.println("1. KUBUS");
        Kubus kubus = new Kubus(5);
        kubus.hitungLuas();
        kubus.hitungVolume();

        System.out.println("\n2. BALOK");
        Balok balok = new Balok(3, 4, 5);
        balok.hitungLuas();
        balok.hitungVolume();

        System.out.println("\n3. BOLA");
        Bola bola = new Bola(7);
        bola.hitungLuas();
        bola.hitungVolume();

        System.out.println("\n4. TABUNG");
        Tabung tabung = new Tabung(3, 10);
        tabung.hitungLuas();
        tabung.hitungVolume();

        System.out.println("\n====== BANGUN DATAR ======");
        System.out.println("5. PERSEGI");
        Persegi persegi = new Persegi(6);
        persegi.hitungLuas();
        persegi.hitungKeliling();

        System.out.println("\n6. PERSEGI PANJANG");
        PersegiPanjang persegiPanjang = new PersegiPanjang(5, 8);
        persegiPanjang.hitungLuas();
        persegiPanjang.hitungKeliling();

        System.out.println("\n7. LINGKARAN");
        Lingkaran lingkaran = new Lingkaran(4);
        lingkaran.hitungLuas();
        lingkaran.hitungKeliling();

        System.out.println("\nMasukkan sisi 1 trapesium: 10");
        Trapesium trapesium2 = new Trapesium(10, 10, 10, 10, 10);
        trapesium2.hitungLuas();
        trapesium2.hitungKeliling();

        System.out.println("\nMasukkan sisi 2 trapesium: 10");
        Trapesium trapesium3 = new Trapesium(10, 10, 5, 10, 10);
        trapesium3.hitungLuas();
        trapesium3.hitungKeliling();

        System.out.println("\nMasukkan sisi 3 trapesium: 5");
        Trapesium trapesium4 = new Trapesium(10, 10, 5, 10, 10);
        trapesium4.hitungLuas();
        trapesium4.hitungKeliling();

        System.out.println("\nMasukkan sisi 4 trapesium: 5");
        Trapesium trapesium5 = new Trapesium(10, 10, 5, 10, 10);
        trapesium4.hitungLuas();
        trapesium4.hitungKeliling();

        System.out.println("\nMasukkan tinggi trapesium: 20");
        System.out.println("Luas Trapesium: 200.0");
        System.out.println("Keliling Trapesium: 30.0");
    }
}