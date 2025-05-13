import java.util.Scanner;

public class JogoDaForcaSangalletti { // Nome da classe principal do jogo da forca

    public static void main(String[] args) {

        Forca jogo = new Forca(); // Cria uma nova instância do jogo

        jogo.comecar(); // Inicia o jogo

        Scanner scanner = new Scanner(System.in); // Cria um scanner para ler entradas do usuário

        // Loop principal do jogo
        while (jogo.isTerminou() == false) {
            System.out.println("\n" + jogo.getDesenho());
            System.out.println("Palavra: " + jogo.getExibicao());
            System.out.println("Letras usadas: " + jogo.getLetras());
            System.out.println("Tentativas: " + jogo.getTentativas());
            System.out.print("Digite uma letra: ");
            String entrada = scanner.nextLine(); // Lê a entrada do usuário
            if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) { // Verifica se a entrada tem mais de um caractere
                continue; // Se não for uma letra, continua o loop

            }

            //Tentar a letra
            jogo.tentarLetra(entrada.charAt(0)); // Chama o método para tentar a letra

        }

        // Exibe a mensagem de fim de jogo
        System.out.println("\n" + jogo.getDesenho()); // Corrigido de "/n" para "\n"
        scanner.close(); // Fecha o scanner
    }
}
