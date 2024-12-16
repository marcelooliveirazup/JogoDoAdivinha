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
            int palpite;
            try {
                palpite = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            // Avaliação do palpite
            if (palpite == numeroSorteado) {
                JOptionPane.showMessageDialog(null, "Parabéns! Você acertou! Ganhou 10 pontos.");
                pontuacaoTotal += 10;
                numerosAcertados.append(numeroSorteado).append(" ");
            } else if (Math.abs(palpite - numeroSorteado) == 1) {
                JOptionPane.showMessageDialog(null, "Quase! Você estava a 1 de distância. Ganhou 5 pontos.");
                pontuacaoTotal += 5;
                numerosErrados.append(numeroSorteado).append(" ");
            } else {
                JOptionPane.showMessageDialog(null, "Errou! O número era " + numeroSorteado + ".");
                numerosErrados.append(numeroSorteado).append(" ");
            }

            // Verifica se o jogador quer continuar
            int resposta = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja jogar novamente?",
                    "Jogo do Adivinha",
                    JOptionPane.YES_NO_OPTION
            );
            continuar = (resposta == JOptionPane.YES_OPTION);
        }

        // Resultados finais
        String mensagemFinal = "Fim de jogo!\n" +
                "Pontuação total: " + pontuacaoTotal + "\n" +
                "Números acertados: " + (numerosAcertados.length() > 0 ? numerosAcertados : "Nenhum") + "\n" +
                "Números errados: " + (numerosErrados.length() > 0 ? numerosErrados : "Nenhum");

        JOptionPane.showMessageDialog(null, mensagemFinal, "Resultados", JOptionPane.INFORMATION_MESSAGE);
    }
}

