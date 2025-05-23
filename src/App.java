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

        System.out.println("\nTotal de nós: " + arvore.contarNos(arvore.raiz)); 
    }
}
