public class App {
    public static void main(String[] args) {

        // Árvore binária comum
        Arvore arvore = new Arvore();


        arvore.raiz = new No("A");
        arvore.raiz.esquerda = new No("B");
        arvore.raiz.direita = new No("C");
        arvore.raiz.esquerda.esquerda = new No("D");
        arvore.raiz.esquerda.direita = new No("E");
        arvore.raiz.direita.direita = new No("F");

        System.out.println("Contagem de nós (recursiva): " + arvore.contarNos(arvore.raiz));
        System.out.println("Contagem de nós (iterativa): " + arvore.contarNos2(null));

        System.out.println("Contagem de folhas (recursiva): " + arvore.contarFolhas(arvore.raiz));
        System.out.println("Contagem de folhas (iterativa): " + arvore.contarFolhas2(null));

        System.out.print("Pré-ordem: ");
        arvore.preOrdem(arvore.raiz);
        System.out.println();

        System.out.print("Pré-ordem iterativa: ");
        arvore.preOrdem2(null);
        System.out.println();

        System.out.print("Em ordem: ");
        arvore.emOrdem(arvore.raiz);
        System.out.println();

        System.out.print("Em ordem iterativa: ");
        arvore.emOrdem2(null);
        System.out.println();

        System.out.print("Pós-ordem: ");
        arvore.posOrdem(arvore.raiz);
        System.out.println();

        System.out.print("Pós-ordem iterativa: ");
        arvore.posOrdem2(null);
        System.out.println();

        System.out.print("Largura (fila): ");
        arvore.percorrerLargura();
        System.out.println();

        System.out.println("Contagem com fila (recursiva adaptada): " + arvore.contarComFilaRec(arvore.raiz));

        System.out.println("Recursos:");
        arvore.mostrarRecursos();

        // Árvore AVL
        ArvoreAVL avl = new ArvoreAVL();
        avl.inserir("M");
        avl.inserir("B");
        avl.inserir("Q");
        avl.inserir("A");
        avl.inserir("C");

        System.out.print("AVL em ordem: ");
        avl.emOrdem(avl.raiz);
        System.out.println();

        avl.remover("B");

        System.out.print("AVL após remover B: ");
        avl.emOrdem(avl.raiz);
        System.out.println();


        ArvoreRubroNegra arvore = new ArvoreRubroNegra();

        arvore.inserir("M");
        arvore.inserir("B");
        arvore.inserir("Q");
        arvore.inserir("A");
        arvore.inserir("C");
        arvore.inserir("Z");

        System.out.print("Em ordem com cor: ");
        arvore.emOrdem(arvore.getRaiz());
        System.out.println();

        arvore.removerSimples("A");

        System.out.print("Após remover A: ");
        arvore.emOrdem(arvore.getRaiz());
    }
}
    
