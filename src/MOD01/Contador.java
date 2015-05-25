/**
 * Escreva a descrição da classe Contador aqui.
 * 
 * @author  Arionildo.Escouto
 * @version 08/04/2015
 */
public class Contador
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int x;

    /**
     * Construtor para objetos da classe Contador
     */
    public Contador()
    {
        
    }
    
    public void contarAte3() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(i);
        }
    }
    
    public void contarAte1003() {
        for (int i = 1; i <= 1003; i++) {
            System.out.println(i);
        }
    }
    
    public void contarAteN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }
    
    public void contarRegressivamenteAteN(int n) {
        for (int i = n; i >= 1; i--) {
            System.out.println(i);
        }
    }
}
