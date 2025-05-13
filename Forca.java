import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Classe filha que herda de JogoBase
public class Forca extends JogoBase {

    // Atributos privados
    private String palavra; // Palavra secreta
    private char[] exibicao; // Representação atual da palavra (com letras descobertas e '_')
    private List<Character> letras; // Lista de letras já tentadas
    private static final String[] PALAVRAS = {"IFRO", "LUA", "SOL", "IF"}; // Palavras disponíveis para o jogo
    private static final String[] DESENHO = {
        "-----\n|    \n|        \n|        \n|    ", // 0 erros
        "-----\n|  O \n|        \n|        \n|    ", // 1 erro
        "-----\n|  O \n|   |    \n|        \n|    ", // 2 erros
        "-----\n|  O \n|  /|    \n|        \n|    ", // 3 erros
        "-----\n|  O \n|  /|\\  \n|        \n|    ", // 4 erros
        "-----\n|  O \n|  /|\\  \n|  /     \n|    ", // 5 erros
        "-----\n|  O \n|  /|\\  \n|  / \\  \n|    " // 6 erros
    };

    // Construtor
    public Forca() {
        super(); // Chama o construtor da classe base
        letras = new ArrayList<>(); // Inicializa a lista de letras tentadas
    }

    // Método para iniciar o jogo
    public void comecar() {
        Random random = new Random();
        palavra = PALAVRAS[random.nextInt(PALAVRAS.length)]; // Seleciona uma palavra aleatória

        exibicao = new char[palavra.length()]; // Inicializa o array de exibição com o tamanho da palavra

        // Preenche o array de exibição com '_'
        for (int i = 0; i < palavra.length(); i++) {
            exibicao[i] = '_';
        }

        System.out.println("O jogo começou!");
    }

    // Método para processar tentativas do jogador
    public void tentarLetra(char letra) {
        letra = Character.toUpperCase(letra); // Converte a letra para maiúscula

        // Verifica se a letra já foi tentada
        if (letras.contains(letra)) {
            System.out.println("Você já tentou essa letra!");
            return;
        }

        letras.add(letra); // Adiciona a letra à lista de tentativas

        boolean acertou = false; // Flag para verificar se a letra está na palavra

        // Verifica se a letra está na palavra e atualiza a exibição
        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == letra) {
                exibicao[i] = letra;
                acertou = true;
            }
        }

        // Se a letra não estiver na palavra, registra como erro
        if (!acertou) {
            System.out.println("Letra errada!");
            usarTentativas(); // Usa uma tentativa
        }

        // Verifica se o jogador acertou a palavra inteira
        if (String.valueOf(exibicao).equals(palavra)) {
            System.out.println("Você acertou a palavra!");
            finalizar(); // Finaliza o jogo
        }

        // Verifica se o jogador perdeu
        if (getTentativas() == 0) {
            System.out.println("Você perdeu! A palavra era: " + palavra);
            finalizar(); // Finaliza o jogo
        }
    }

    // Método para obter o estado atual da palavra (com letras descobertas e '_')
    public String getExibicao() {
        return String.valueOf(exibicao);
    }

    // Método para obter as letras já tentadas
    public List<Character> getLetras() {
        return letras;
    }

    // Método para obter o desenho atual da forca
    public String getDesenho() {
        return DESENHO[6 - getTentativas()]; // Retorna o desenho correspondente ao número de erros
    }
}
