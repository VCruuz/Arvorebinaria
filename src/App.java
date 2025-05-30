public class App {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        System.out.println("Pré-ordem:");
        arvore.preOrdem(arvore.raiz);  

        System.out.println("\nEm-ordem:");
        arvore.emOrdem(arvore.raiz);   

        System.out.println("\nPós-ordem:");
        arvore.posOrdem(arvore.raiz);  

        System.out.println("\nEm largura:");
        arvore.emLargura();          

        System.out.println("\n\nRecursos da árvore:");
        arvore.mostrarRecursos();
        
        System.out.println("Pré-ordem iterativa:");
        arvore.preOrdem2(arvore.raiz);
        

        System.out.println("\nEm-ordem iterativa:");
        arvore.emOrdem2(arvore.raiz);

        System.out.println("\nPós-ordem iterativa:");
        arvore.posOrdem2(arvore.raiz);

        System.out.println("\nLargura iterativa:");
arvore.emLargura2();

System.out.println("\nTotal de nós (iterativo): " + arvore.contarNos2(arvore.raiz));
System.out.println("Total de folhas (iterativo): " + arvore.contarFolhas2(arvore.raiz));
System.out.println("Altura da árvore (iterativo): " + arvore.altura2(arvore.raiz));
    }
}