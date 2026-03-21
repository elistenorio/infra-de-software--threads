import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Principal{
    public static void main(String[] args) {

        JFrame janela = new JFrame("Minha Banda");
        janela.setLayout(new GridLayout(4, 1));
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

        Instrumento baixo = new Instrumento(textoBaixo, "Baixo", "dumm dumm dumm");
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

        Instrumento bateria = new Instrumento(textoBateria, "Bateria", "badum-tsssss");
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


        Instrumento synth = new Instrumento(textoSynth, "Synth", "poimmmmmm poimmmmm");
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

        Instrumento guitarra = new Instrumento(textoGuitarra, "Guitarra", "strumm strumm");
        guitarra.ligar();

        botaoGuitarra.addActionListener(e -> guitarra.alternar());
        botaoInterromperGuitarra.addActionListener(e -> guitarra.interromper());



        Scanner scanner = new Scanner(System.in);
        System.out.println("Terminal ativo!!!!!!");

        while (true) {
            String linha = scanner.nextLine();
            String[] comando = linha.split(" ");

            if(comando.length > 1){
                switch(comando[0].toLowerCase()){
                    case "baixo":
                        baixo.setBpm(Integer.parseInt(comando[1]));
                        break;
                    case "guitarra":
                        guitarra.setBpm(Integer.parseInt(comando[1]));
                        break;
                    case "bateria":
                        bateria.setBpm(Integer.parseInt(comando[1]));
                        break;
                    case "synth":
                        synth.setBpm(Integer.parseInt(comando[1]));
                        break;
                }
            }
            if(comando[0].equalsIgnoreCase("interromper")){
                bateria.interromper();
                synth.interromper();
                guitarra.interromper();
                baixo.interromper();
                break;
            }
        }

        scanner.close();
        janela.dispose();
    }
}