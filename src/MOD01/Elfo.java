/**
 * Escreva a descrição da classe Elfo aqui.
 * 
 * @author  Arionildo.Escouto
 * @version 20/04/2015
 */
public class Elfo extends Personagem
{
    protected int flechas;
    protected final int danoFlechas = 10;
    private static int contador;

    /**
     * Construtor para objetos da classe Elfo
     */
    public Elfo(String novoNome, int novoflechas)
    {
        this(novoNome);
        this.flechas = novoflechas;
    }
    
    public Elfo(String novoNome)
    {
        super(100);
        this.nome = novoNome;
        this.flechas = 42;
        setContagem();
    }
    
    public void setContagem() {
        contador++;
    }
    
    public static void resetContagem() {
        contador = 0;
    }
    
    public static int getContagem() {
        return contador;
    }
    
    public double atirarFlecha(Orc orc){
        if (flechas > 0 && orc.getStatus() == Status.VIVO) {            
            flechas--;
            orc.diminuirVida(danoFlechas);
            setExp(7);
            setStatus(3);
        }
        
        return orc.getVida();
    }
    
    public void setFlechas(int novoFlechas){
        if (novoFlechas > flechas) {
            this.flechas = novoFlechas;
        }
    }
    
    public int getFlechas() {
        return this.flechas;
    }
    
    @Override
    public String toString() {
        return String.format(
            "%s possui %d flechas e %d níveis de experiência.",
            this.getNome(),
            this.getFlechas(),
            this.getExperiencia()
        );
    }
}
