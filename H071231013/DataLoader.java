import javax.sound.sampled.*;
import java.io.File;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataLoader {
    private static final int NUM_DATA = 4;
    private static final int MAX_LOAD_TIME = 6;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new UIThread());
        executorService.execute(new BackgroundThread());
        executorService.shutdown();
    }

    public static void playAudio(String audioFilePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem
                    .getAudioInputStream(new File(audioFilePath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
            clip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class UIThread implements Runnable {
        @Override
        public void run() {
            System.out.println("Start load " + NUM_DATA + " Data");
            for (int i = 1; i <= NUM_DATA + 1; i++) {
                System.out.println("Loading... (" + i + "s)");
                try {
                    Thread.sleep(TaskTimeHelper.getRandomTime() * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == NUM_DATA + 1) {
                    System.out.println("Request Timeout");
                } else {
                    playAudio("race-care-151963.wav");
                }
            }
        }
    }

    private static class BackgroundThread implements Runnable {
        @Override
        public void run() {
            int successCount = 0;
            int failedCount = 0;
            long startTime = System.currentTimeMillis();
            System.out.println("Saat semua data berhasil di load");
            for (int i = 1; i <= NUM_DATA; i++) {
                try {
                    Thread.sleep(TaskTimeHelper.getRandomTime() * 1000);
                    successCount++;
                } catch (InterruptedException e) {
                    failedCount++;
                }
            }
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            System.out.println("Task Finish.");
            System.out.println("Time Execution : " + executionTime / 1000 + "s");
            System.out.println(successCount + " Data Successfully Loaded & " + failedCount + " Data failed to load");
            if (failedCount == 0) {
                System.out.println("\nSaat ada data yang gagal di load");
                System.out.println("Start load " + NUM_DATA + " Data");
                for (int i = 1; i <= NUM_DATA; i++) {
                    System.out.println("Loading... (" + i + "s)");
                    try {
                        Thread.sleep(TaskTimeHelper.getRandomTime() * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("\nTask Finish.");
                System.out.println("Time Execution : " + executionTime / 1000 + "s");
                System.out.println("All data is successfully loaded");
            }
        }
    }

    private static class TaskTimeHelper {
        private static final Random random = new Random();

        public static int getRandomTime() {
            return random.nextInt(MAX_LOAD_TIME) + 1;
        }
    }
}