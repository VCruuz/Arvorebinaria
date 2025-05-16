class Arvore {
    No raiz;

    public Arvore() {
        construirArvore();
    }

    private void construirArvore() {
        // Criando os nós
        No noA = new No("A");
        No noB = new No("B");
        No noC = new No("C");
        No noD = new No("D");
        No noE = new No("E");
        No noF = new No("F");

        // Montando a estrutura
        noA.esquerda = noB;
        noA.direita = noC;

        noB.esquerda = noD;
        noB.direita = noE;

        noC.direita = noF;

        // Definindo a raiz
        this.raiz = noA;
    }

    // Percurso pré-ordem para verificar a estrutura
    public void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }
}