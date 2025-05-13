//Classe pai - Base do jogo
//Gerencia tentativas e termino

public class JogoBase {

    //Atributos privados
    private int tentativas;
    private boolean terminou;

    //Construtor com 6 tentativas
    //Terminou colocando para false
    public JogoBase() {
        this.tentativas = 6;
        this.terminou = false;
    }

    //Getter para tentativas
    public int getTentativas() {
        return tentativas;
    }

    //Getter para terminou
    public boolean isTerminou() {
        return terminou;
    }

    //Metodo para usar tentativas
    public void usarTentativas() {
        if (tentativas > 0) {
            tentativas--;
        }
    }

    //Metodo para terminar
    public void finalizar() {
        terminou = true;
    }
}
