public class App {
   public static void main(String[] args) {
        Arvore arvore = new Arvore();
        System.out.println("Percurso pré-ordem da árvore:");
        arvore.preOrdem(arvore.raiz);  
    }
}

