import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Typer extends Thread {
    private String botName;
    private String wordsTyped;
    private double wpm;
    private TypeRacer typeRacer;

    public Typer(String botName, double wpm, TypeRacer typeRacer) {
        this.botName = botName;
        this.wpm = wpm;
        this.wordsTyped = "";
        this.typeRacer = typeRacer;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public void setWpm(int wpm) {
        this.wpm = wpm;
    }

    public void addWordTyped(String newWordsTyped) {
        this.wordsTyped += newWordsTyped + " ";
    }

    public String getWordsTyped() {
        return wordsTyped;
    }

    public String getBotName() {
        return botName;
    }

    public double getWpm() {
        return wpm;
    }

    @Override
    public void run() {
        String[] wordsToType = typeRacer.getWordsToType().split(" ");
        long howLongToType = (long) (60000 / wpm);
        long startTime = System.currentTimeMillis();

        for (String word : wordsToType) {
            try {
                Thread.sleep(howLongToType);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.addWordTyped(word);
        }

        this.addWordTyped("(selesai)");
        long finishTime = System.currentTimeMillis() - startTime;
        typeRacer.addResult(this, finishTime);
    }
}

class Result {
    private Typer typer;
    private long finishTime;
    private String prize; // Tambahkan properti prize

    public Result(Typer typer, long finishTime) {
        this.typer = typer;
        this.finishTime = finishTime;
        this.prize = ""; // Inisialisasi prize dengan string kosong
    }

    public Typer getTyper() {
        return typer;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public String getPrize() { // Tambahkan getter untuk prize
        return prize;
    }

    public void setPrize(String prize) { // Tambahkan setter untuk prize
        this.prize = prize;
    }
}

class TypeRacer {
    private String wordsToType;
    private ArrayList<Typer> raceContestant = new ArrayList<>();
    private ArrayList<Result> raceStanding = new ArrayList<>();

    public String getWordsToType() {
        return wordsToType;
    }

    public ArrayList<Typer> getRaceContestant() {
        return raceContestant;
    }

    private String[] wordsToTypeList = {
            "Sistem informasi adalah jantung organisasi modern.",
            "Data menggerakkan dunia; sistem informasi mengarahkannya.",
            "Inovasi lahir dari sistem informasi yang efektif.",
            "Transformasi digital dimulai dengan sistem informasi.",
            "Integritas data adalah dasar kepercayaan.",
            "Sistem informasi: kunci keunggulan kompetitif.",
            "Manajemen data yang baik, keputusan yang lebih baik.",
            "Sistem informasi mengubah data menjadi wawasan.",
            "Kemajuan bisnis melalui sistem informasi.",
            "Era digital didorong oleh sistem informasi."
    };

    public void setNewWordsToType() {
        Random random = new Random();
        int angkaRandom = random.nextInt(wordsToTypeList.length);
        wordsToType = wordsToTypeList[angkaRandom];
    }

    public synchronized void addResult(Typer typer, long finishTime) {
        raceStanding.add(new Result(typer, finishTime));
    }

    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer:");
        raceStanding.sort((r1, r2) -> Long.compare(r1.getFinishTime(), r2.getFinishTime()));
        for (int i = 0; i < raceStanding.size(); i++) {
            Result result = raceStanding.get(i);
            String prize = ""; // Inisialisasi variabel prize
            if (i == 0) { // Jika peringkat pertama
                prize = "Juara 1: Laptop Gaming";
            } else if (i == 1) { // Jika peringkat kedua
                prize = "Juara 2: Headset Gaming";
            } else if (i == 2) { // Jika peringkat ketiga
                prize = "Juara 3: Mouse Gaming";
            }
            result.setPrize(prize); // Set prize pada objek Result
            System.out.printf("%d. %s = %.2f detik (Hadiah: %s)\n", i + 1, result.getTyper().getBotName(),
                    result.getFinishTime() / 1000.0, result.getPrize());
        }
    }

    public void startRace() {
        for (Typer typer : raceContestant) {
            typer.start();
        }

        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("\nTyping Progress:");
            for (Typer typer : raceContestant) {
                System.out.printf("%s => %s\n", typer.getBotName(), typer.getWordsTyped());
            }

            boolean allFinished = raceContestant.stream().allMatch(t -> t.getWordsTyped().contains("(selesai)"));
            if (allFinished) {
                break;
            }
        }

        printRaceStanding();
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TypeRacer typeRacer = new TypeRacer();
        typeRacer.setNewWordsToType();

        System.out.println("|| Text to Type ||");
        System.out.println("\"" + typeRacer.getWordsToType() + "\"");

        Typer[] typers = new Typer[3];
        typers[0] = new Typer("Bot Mansur", 80, typeRacer);
        typers[1] = new Typer("Bot ToKu", 80, typeRacer);
        typers[2] = new Typer("Bot Yukiao", 80, typeRacer);

        typeRacer.getRaceContestant().addAll(Arrays.asList(typers));

        typeRacer.startRace();
    }
}