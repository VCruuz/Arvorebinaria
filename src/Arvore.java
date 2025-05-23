public class Arvore {
    No raiz;

    public Arvore() {
        No a = new No("A");
        No b = new No("B");
        No c = new No("C");
        No d = new No("D");
        No e = new No("E");
        No f = new No("F");

        a.esquerda = b;
        a.direita = c;

        b.esquerda = d;
        b.direita = e;

        c.direita = f;

        raiz = a;
    }

    public void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }

    public void emOrdem(No no) {
        if (no != null) {
            emOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdem(no.direita);
        }
    }

    public void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.esquerda);
            posOrdem(no.direita);
            System.out.print(no.valor + " ");
        }
    }

    public int contarNos(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }
}
