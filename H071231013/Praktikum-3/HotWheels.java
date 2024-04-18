class HotWheels {
    String name;
    double speed, cash;
    int winningAmount;

    // Todo 1: membuat konstruktor sesuai kebutuhan di main.java
    public HotWheels(String name, double speed, double cash) {
        this.name = name;
        this.speed = speed;

        this.cash = cash;
    }
    // Konstruktor ini digunakan untuk membuat objek HotWheels dengan
    // menginisialisasi nilai name, speed, dan cash.

    // untuk mencetak spesifikasi objek HotWheels dengan memanggil metode getter
    // (getName(), getSpeed(), getWinningAmount(), dan getCash()).
    public void showSpec() {
        // Todo 2: memanggil semua metode pengambil dan cetak hasilnya sesuai format
        System.out.println("============ Specification ============");
        System.out.println("Name            : " + getName());
        System.out.println("Speed           : " + getSpeed());
        System.out.println("Winning Amount  : " + getWinningAmount());
        System.out.println("Cash            : Rp. " + getCash() + "\n\n");
    }

    // Meningkatkan kecepatan objek HotWheels. Jika budget lebih besar dari cash,
    // maka akan mencetak pesan bahwa upgrade tidak dapat dilakukan karena uang
    // tidak cukup. Jika budget cukup, maka kecepatan akan ditingkatkan sesuai
    // dengan budget (setiap Rp. 50.000 meningkatkan kecepatan sebesar 1), dan cash
    // akan dikurangi sesuai dengan budget dikurangi dengan sisa pembagian budget
    // dengan 50.000.
    public void upgrade(int budget) {
        if (budget > this.getCash()) {
            System.out.printf("%s cannot be upgraded, not enough money...\n", this.getName());
        } else {
            // Setiap RP. 50.000 peningkatan kecepatan 1
            int increaseSpeed = budget / 50000;

            // Todo 3: Tingkatkan kecepatan
            this.setSpeed(this.getSpeed() + increaseSpeed);

            this.setCash(this.getCash() - budget + (budget % 50000));

            System.out.printf("Increases the speed of %s by %d...\n", this.getName(), increaseSpeed);
        }
    }

    // melakukan pertandingan antara objek HotWheels dengan objek HotWheels lain
    // (enemy).
    public void raceTo(HotWheels enemy) {
        // Todo 4: Memvalidasi jika kecepatan mobil ini lebih besar dari kecepatan musuh
        if (this.getSpeed() > enemy.getSpeed()) {
            // Todo 5: meningkatkan jumlah kemenangan
            this.setWinningAmount(this.getWinningAmount() + 1);

            // Todo 6: Meningkatkan uang tunai mobil sebanyak 40.000
            this.setCash(this.getCash() + 40000);

            // Todo 7: memanggil semua metode pengambil dan cetak hasilnya sesuai dengan
            // format
            System.out.printf("%s Wins! The number of Wins from %s reaches %d wins...\n", this.getName(),
                    this.getName(), this.getWinningAmount());
        } else if (this.getSpeed() == enemy.getSpeed()) { // Jika kecepatannya
            System.out.printf("%s with %s are equally strong! The match ended in a draw...\n", this.getName(),
                    enemy.getName());
        } else { // Jika kecepatan mobil ini lebih kecil dari kecepatan musuh
            // Todo 8: Meningkatkan jumlah kemenangan musuh
            enemy.setWinningAmount(enemy.getWinningAmount() + 1);

            // Todo 9: Meningkatkan uang tunai musuh sebanyak 40000
            enemy.setCash(enemy.getCash() + 40000);

            System.out.printf("%s Wins! The number of Wins from %s reaches %d wins...\n",
                    enemy.getName(), enemy.getName(), enemy.getWinningAmount());
        }
    }

    // Todo 10: Membuat metode pengambil dan penyetel untuk semua atribut
    // Metode getter digunakan untuk mengambil nilai atribut, sedangkan metode
    // setter digunakan untuk mengubah nilai atribut.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(int winningAmount) {
        this.winningAmount = winningAmount;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}