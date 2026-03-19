import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Principal{
    public static void main(String[] args) {

        JFrame janela = new JFrame("Minha Banda");
        janela.setLayout(new GridLayout(2, 1));
        janela.setSize(640, 320);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1. BAIXO

        JPanel painelBaixo = new JPanel(new FlowLayout());
        JLabel textoBaixo = new JLabel("Baixo: Aguardando...");
        textoBaixo.setFont(new Font("Arial", Font.BOLD, 16));
        JButton botaoBaixo = new JButton("Play/Pause");

        JButton botaoInterromperBaixo = new JButton("Stop");

        painelBaixo.add(textoBaixo);
        painelBaixo.add(botaoBaixo);
        painelBaixo.add(botaoInterromperBaixo);

        janela.add(painelBaixo);

        Baixo baixo = new Baixo(textoBaixo);
        baixo.ligar();

        botaoBaixo.addActionListener(e -> baixo.alternar());
        botaoInterromperBaixo.addActionListener(e -> baixo.interromper());


        // 2. BATERIA

        JPanel painelBateria = new JPanel(new FlowLayout());
        JLabel textoBateria = new JLabel("Bateria: Aguardando...");
        textoBateria.setFont(new Font("Arial", Font.BOLD, 16));
        JButton botaoBateria = new JButton("Play/Pause");

        JButton botaoInterromperBateria = new JButton("Stop");

        painelBateria.add(textoBateria);
        painelBateria.add(botaoBateria);
        painelBateria.add(botaoInterromperBateria);

        janela.add(painelBateria);

        Bateria bateria = new Bateria(textoBateria);
        bateria.ligar();

        botaoBateria.addActionListener(e -> bateria.alternar());
        botaoInterromperBateria.addActionListener(e -> bateria.interromper());


        // 3. SYNTH

        JPanel painelSynth = new JPanel(new FlowLayout());
        JLabel textoSynth = new JLabel("Synth: Aguardando...");
        textoSynth.setFont(new Font("Arial", Font.BOLD, 16));
        JButton botaoSynth = new JButton("Play/Pause");

        JButton botaoInterromperSynth = new JButton("Stop");

        painelSynth.add(textoSynth);
        painelSynth.add(botaoSynth);
        painelSynth.add(botaoInterromperSynth);

        janela.add(painelSynth);


        Synth synth = new Synth(textoSynth);
        synth.ligar();

        botaoSynth.addActionListener(e -> synth.alternar());
        botaoInterromperSynth.addActionListener(e -> synth.interromper());


        // 4. GUITARRA

        JPanel painelGuitarra = new JPanel(new FlowLayout());
        JLabel textoGuitarra = new JLabel("Guitarra: Aguardando...");
        textoGuitarra.setFont(new Font("Arial", Font.BOLD, 16));
        JButton botaoGuitarra = new JButton("Play/Pause");

        JButton botaoInterromperGuitarra = new JButton("Stop");

        painelGuitarra.add(textoGuitarra);
        painelGuitarra.add(botaoGuitarra);
        painelGuitarra.add(botaoInterromperGuitarra);

        janela.add(painelGuitarra);

        janela.setVisible(true);

        Guitarra guitarra = new Guitarra(textoGuitarra);
        guitarra.ligar();

        botaoGuitarra.addActionListener(e -> guitarra.alternar());
        botaoInterromperGuitarra.addActionListener(e -> guitarra.interromper());



        Scanner scanner = new Scanner(System.in);
        System.out.println("Terminal ativo!");
        System.out.println("Digite: tocar, pausar, bpm <numero> ou interromper");

        while (true) {
            String linha = scanner.nextLine();
            String[] comando = linha.split(" ");

            if (comando[0].equals("bpm") && comando.length > 1) {
                baixo.setBpm(Integer.parseInt(comando[1]));
            }
            else if (comando[0].equals("interromper")) {
                baixo.interromper();
                break;
            }
            else {
                System.out.println("Comando inválido!");
            }
        }

        scanner.close();
        janela.dispose();
    }
}