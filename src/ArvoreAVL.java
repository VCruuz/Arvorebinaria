public class ArvoreAVL {
    NoAVL raiz;

    public void inserir(String valor) {
        raiz = inserir(raiz, valor);
    }

    private NoAVL inserir(NoAVL no, String valor) {
        if (no == null) return new NoAVL(valor);

        if (valor.compareTo(no.valor) < 0) {
            no.esquerda = inserir(no.esquerda, valor);
        } else if (valor.compareTo(no.valor) > 0) {
            no.direita = inserir(no.direita, valor);
        } else {
            return no; 
        }

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        return balancear(no);
    }

    public void remover(String valor) {
        raiz = remover(raiz, valor);
    }

    private NoAVL remover(NoAVL no, String valor) {
        if (no == null) return null;

        if (valor.compareTo(no.valor) < 0) {
            no.esquerda = remover(no.esquerda, valor);
        } else if (valor.compareTo(no.valor) > 0) {
            no.direita = remover(no.direita, valor);
        } else {
            if (no.esquerda == null) return no.direita;
            if (no.direita == null) return no.esquerda;

            NoAVL temp = menorValor(no.direita);
            no.valor = temp.valor;
            no.direita = remover(no.direita, temp.valor);
        }

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        return balancear(no);
    }

    private NoAVL menorValor(NoAVL no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }

    private int altura(NoAVL no) {
        return (no == null) ? 0 : no.altura;
    }

    private int fatorBalanceamento(NoAVL no) {
        return altura(no.esquerda) - altura(no.direita);
    }

    private NoAVL balancear(NoAVL no) {
        int fb = fatorBalanceamento(no);

        if (fb > 1) {
            if (fatorBalanceamento(no.esquerda) < 0) {
                no.esquerda = rotacaoEsquerda(no.esquerda);
            }
            return rotacaoDireita(no);
        }

        if (fb < -1) {
            if (fatorBalanceamento(no.direita) > 0) {
                no.direita = rotacaoDireita(no.direita);
            }
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerda;
        y.esquerda = x.direita;
        x.direita = y;

        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));
        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));

        return x;
    }

    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        x.direita = y.esquerda;
        y.esquerda = x;

        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));
        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));

        return y;
    }

    public void emOrdem(NoAVL no) {
        if (no != null) {
            emOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdem(no.direita);
        }
    }
}
