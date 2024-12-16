import javax.swing.JOptionPane;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int pontuacaoTotal = 0;
        StringBuilder numerosAcertados = new StringBuilder();
        StringBuilder numerosErrados = new StringBuilder();

        // Menu de nível de dificuldade
        String[] niveis = {"Fácil (1 a 10)", "Médio (1 a 50)", "Difícil (1 a 100)"};
        int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha o nível de dificuldade:",
                "Jogo do Adivinha",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                niveis,
                niveis[0]
        );

        int intervalo = switch (escolha) {
            case 0 -> 10;
            case 1 -> 50;
            case 2 -> 100;
            default -> 10;
        };

        boolean continuar = true;
        while (continuar) {
            int numeroSorteado = random.nextInt(intervalo) + 1;

            // Pede ao jogador para digitar seu palpite
            String entrada = JOptionPane.showInputDialog(
                    null,
                    "Digite seu palpite (1 a " + intervalo + "):",
                    "Jogo do Adivinha",
                    JOptionPane.QUESTION_MESSAGE
            );

            // Encerra se o jogador cancelar
            if (entrada == null) break;
        }


}