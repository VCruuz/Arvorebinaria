import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    public void preOrdem2(No no) {
    if (no == null) return;

    Stack<No> pilha = new Stack<>();
    pilha.push(no);

    while (!pilha.isEmpty()) {
        No atual = pilha.pop();
        System.out.print(atual.valor + " ");

        if (atual.direita != null) pilha.push(atual.direita);
        if (atual.esquerda != null) pilha.push(atual.esquerda);
    }
}
    public void emOrdem2(No no) {
    Stack<No> pilha = new Stack<>();
    No atual = no;

    while (atual != null || !pilha.isEmpty()) {
        while (atual != null) {
            pilha.push(atual);
            atual = atual.esquerda;
        }

        atual = pilha.pop();
        System.out.print(atual.valor + " ");
        atual = atual.direita;
    }
}
public void posOrdem2(No no) {
    if (no == null) return;

    Stack<No> pilha1 = new Stack<>();
    Stack<No> pilha2 = new Stack<>();

    pilha1.push(no);

    while (!pilha1.isEmpty()) {
        No atual = pilha1.pop();
        pilha2.push(atual);

        if (atual.esquerda != null) pilha1.push(atual.esquerda);
        if (atual.direita != null) pilha1.push(atual.direita);
    }

    while (!pilha2.isEmpty()) {
        System.out.print(pilha2.pop().valor + " ");
    }
}
public void emLargura2() {
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
public int contarNos2(No no) {
    if (no == null) return 0;

    int count = 0;
    Stack<No> pilha = new Stack<>();
    pilha.push(no);

    while (!pilha.isEmpty()) {
        No atual = pilha.pop();
        count++;

        if (atual.direita != null) pilha.push(atual.direita);
        if (atual.esquerda != null) pilha.push(atual.esquerda);
    }

    return count;
}
public int contarFolhas2(No no) {
    if (no == null) return 0;

    int folhas = 0;
    Stack<No> pilha = new Stack<>();
    pilha.push(no);

    while (!pilha.isEmpty()) {
        No atual = pilha.pop();

        if (atual.esquerda == null && atual.direita == null) {
            folhas++;
        }

        if (atual.direita != null) pilha.push(atual.direita);
        if (atual.esquerda != null) pilha.push(atual.esquerda);
    }

    return folhas;
}
public int altura2(No no) {
    if (no == null) return 0;

    Queue<No> fila = new LinkedList<>();
    fila.add(no);
    int altura = 0;

    while (!fila.isEmpty()) {
        int nivelSize = fila.size();
        for (int i = 0; i < nivelSize; i++) {
            No atual = fila.poll();
            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }
        altura++;
    }

    return altura;
}
public int contarNosFilaRecursivo(Queue<No> fila) {
    if (fila.isEmpty()) return 0;

    No atual = fila.poll();

    if (atual.esquerda != null) fila.add(atual.esquerda);
    if (atual.direita != null) fila.add(atual.direita);

    return 1 + contarNosFilaRecursivo(fila);
}

public void percorrerLargura() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'percorrerLargura'");
}

public String contarComFilaRec(No raiz2) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'contarComFilaRec'");
}

}