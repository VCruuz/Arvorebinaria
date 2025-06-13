public class ArvoreRubroNegra {
    private NoRB raiz;

    private void rotacaoEsquerda(NoRB x) {
        NoRB y = x.direita;
        x.direita = y.esquerda;
        if (y.esquerda != null) y.esquerda.pai = x;

        y.pai = x.pai;
        if (x.pai == null) {
            raiz = y;
        } else if (x == x.pai.esquerda) {
            x.pai.esquerda = y;
        } else {
            x.pai.direita = y;
        }

        y.esquerda = x;
        x.pai = y;
    }

    private void rotacaoDireita(NoRB y) {
        NoRB x = y.esquerda;
        y.esquerda = x.direita;
        if (x.direita != null) x.direita.pai = y;

        x.pai = y.pai;
        if (y.pai == null) {
            raiz = x;
        } else if (y == y.pai.esquerda) {
            y.pai.esquerda = x;
        } else {
            y.pai.direita = x;
        }

        x.direita = y;
        y.pai = x;
    }

    public void inserir(String valor) {
        NoRB novo = new NoRB(valor);
        raiz = inserir(raiz, novo);
        corrigirInsercao(novo);
    }

    private NoRB inserir(NoRB atual, NoRB novo) {
        if (atual == null) return novo;

        if (novo.valor.compareTo(atual.valor) < 0) {
            atual.esquerda = inserir(atual.esquerda, novo);
            atual.esquerda.pai = atual;
        } else {
            atual.direita = inserir(atual.direita, novo);
            atual.direita.pai = atual;
        }

        return atual;
    }

    private void corrigirInsercao(NoRB z) {
        while (z.pai != null && z.pai.cor == NoRB.VERMELHO) {
            if (z.pai == z.pai.pai.esquerda) {
                NoRB tio = z.pai.pai.direita;
                if (tio != null && tio.cor == NoRB.VERMELHO) {
                    z.pai.cor = NoRB.PRETO;
                    tio.cor = NoRB.PRETO;
                    z.pai.pai.cor = NoRB.VERMELHO;
                    z = z.pai.pai;
                } else {
                    if (z == z.pai.direita) {
                        z = z.pai;
                        rotacaoEsquerda(z);
                    }
                    z.pai.cor = NoRB.PRETO;
                    z.pai.pai.cor = NoRB.VERMELHO;
                    rotacaoDireita(z.pai.pai);
                }
            } else {
                NoRB tio = z.pai.pai.esquerda;
                if (tio != null && tio.cor == NoRB.VERMELHO) {
                    z.pai.cor = NoRB.PRETO;
                    tio.cor = NoRB.PRETO;
                    z.pai.pai.cor = NoRB.VERMELHO;
                    z = z.pai.pai;
                } else {
                    if (z == z.pai.esquerda) {
                        z = z.pai;
                        rotacaoDireita(z);
                    }
                    z.pai.cor = NoRB.PRETO;
                    z.pai.pai.cor = NoRB.VERMELHO;
                    rotacaoEsquerda(z.pai.pai);
                }
            }
        }
        raiz.cor = NoRB.PRETO;
    }

    public void emOrdem(NoRB no) {
        if (no != null) {
            emOrdem(no.esquerda);
            String cor = (no.cor == NoRB.VERMELHO) ? "V" : "P";
            System.out.print(no.valor + "(" + cor + ") ");
            emOrdem(no.direita);
        }
    }

    public NoRB getRaiz() {
        return raiz;
    }

    public void removerSimples(String valor) {
        raiz = removerSimples(raiz, valor);
    }

    private NoRB removerSimples(NoRB no, String valor) {
        if (no == null) return null;

        if (valor.compareTo(no.valor) < 0) {
            no.esquerda = removerSimples(no.esquerda, valor);
        } else if (valor.compareTo(no.valor) > 0) {
            no.direita = removerSimples(no.direita, valor);
        } else {
            if (no.esquerda == null && no.direita == null) {
                return null; 
            }
            System.out.println("Remoção só de folhas implementada.");
        }

        return no;
    }
}
