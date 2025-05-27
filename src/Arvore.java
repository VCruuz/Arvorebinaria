import java.util.LinkedList;
import java.util.Queue;

public class Arvore {
    No raiz;

    public Arvore() {
        construirArvore();
    }

    private void construirArvore() {
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

    public void emLargura() {
        if (raiz == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.print(atual.valor + " ");

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }
    }

    public int contarNos(No no) {
        if (no == null) return 0;
        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }

    public int altura(No no) {
        if (no == null) return 0;
        return 1 + Math.max(altura(no.esquerda), altura(no.direita));
    }

    public int contarFolhas(No no) {
        if (no == null) return 0;
        if (no.esquerda == null && no.direita == null) return 1;
        return contarFolhas(no.esquerda) + contarFolhas(no.direita);
    }

    public void mostrarRecursos() {
        System.out.println("=== Recursos da Árvore ===");
        System.out.println("Total de nós: " + contarNos(raiz));
        System.out.println("Altura da árvore: " + altura(raiz));
        System.out.println("Número de folhas: " + contarFolhas(raiz));
        System.out.print("Valores (Pré-ordem): ");
        preOrdem(raiz);
        System.out.println("\n===========================");
    }    
}
