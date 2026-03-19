import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Principal{
    public static void main(String[] args) {

        JFrame janela = new JFrame("Minha Banda");
        janela.setLayout(new GridLayout(2, 1));
        janela.setSize(640, 320);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel painelBaixo = new JPanel(new FlowLayout());
        JLabel textoBaixo = new JLabel("Baixo: Aguardando...");
        textoBaixo.setFont(new Font("Arial", Font.BOLD, 16));
        JButton botaoBaixo = new JButton("Play/Pause");

        JButton botaoInterromper = new JButton("Stop");

        painelBaixo.add(textoBaixo);
        painelBaixo.add(botaoBaixo);
        painelBaixo.add(botaoInterromper);

        janela.add(painelBaixo);
        janela.setVisible(true);


        Baixo baixo = new Baixo(textoBaixo);
        baixo.ligar();

        botaoBaixo.addActionListener(e -> baixo.alternar());
        botaoInterromper.addActionListener(e -> baixo.interromper());

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