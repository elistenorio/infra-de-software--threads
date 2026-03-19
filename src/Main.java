import java.util.Scanner;

public class Main {

    static boolean pausaBateria = true;
    static final Object lock = new Object();

    public static void main(String[] args) {

        Thread bateria = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (pausaBateria) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
                System.out.println("Badum-tssss");

                try {
                    Thread.sleep(500); //eh bom a gente fazer um calculo de bpm aqui pra a gente conseguir mudar o bpm depois
                } catch (InterruptedException e) {
                    return;
                }
            }
        });

        bateria.start();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String status = scanner.nextLine();

            if (status.equals("tocar")) {
                synchronized (lock) {
                    pausaBateria = false;
                    lock.notify();
                }
            }
            else if (status.equals("pausar")) {
                synchronized (lock) {
                    pausaBateria = true;
                }
            }
            else if (status.equals("interromper")) {
                bateria.interrupt(); // Isso aqui manda a thread interromper, é necessário?
                break;
            }
        }

        scanner.close();
    }
}