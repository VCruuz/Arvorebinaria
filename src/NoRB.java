public class NoRB {
    String valor;
    int cor; 
    NoRB esquerda;
    NoRB direita;
    NoRB pai;

    public static final int PRETO = 0;
    public static final int VERMELHO = 1;

    public NoRB(String valor) {
        this.valor = valor;
        this.cor = VERMELHO; 
    }
}
