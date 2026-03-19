import javax.swing.*;
import java.awt.*;

public class Baixo {
    private boolean pausa = true;
    private int bpm = 120;
    private final Object lock = new Object();
    private Thread thread;
    private JLabel label;

    public Baixo(JLabel label) {
        this.label = label;

        thread = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (pausa) {
                        try {
                            atualizarTela("Status Baixo: PAUSADO -- BPM: " + bpm, Color.RED);
                            lock.wait();
                        } catch (InterruptedException e) { return; }
                    }
                }

                atualizarTela("Status Baixo: TOCANDO -- BPM: " + bpm, new Color(0, 150, 0));
                System.out.println("Dummmm dummmmm dummmm");

                try {
                    int tempoEspera;
                    synchronized (lock) {
                        tempoEspera = 60000 / bpm;
                    }
                    Thread.sleep(tempoEspera);
                } catch (InterruptedException e){
                    return;
                }
            }
        });
    }

    public void ligar() {
        thread.start();
    }

    public void tocar(){
        synchronized (lock){
        pausa = false; lock.notify();
        }
    }
    public void pausar(){
        synchronized (lock){
            pausa = true;
        }
    }

    public void alternar(){
        synchronized (lock) {
            if (pausa) tocar();
            else pausar();
        }
    }

    public void setBpm(int novoBpm) {
        synchronized (lock) { this.bpm = novoBpm; }
    }

    public void interromper(){
        atualizarTela("Status Baixo: INTERROMPIDO -- BPM: " + bpm, Color.RED);
        thread.interrupt();
    }

    private void atualizarTela(String texto, Color cor) {
        SwingUtilities.invokeLater(() -> {
            label.setText(texto);
            label.setForeground(cor);
        });
    }
}