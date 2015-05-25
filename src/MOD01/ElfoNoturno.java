
/**
 * Escreva a descrição da classe ElfoNoturno aqui.
 * 
 * @author  Arionildo.Escouto
 * @version 20/04/2015
 */
public class ElfoNoturno extends Elfo
{
    private int multiplicadorDeExperiencia = 3;
    
    /**
     * Construtor de Elfo's Noturnos com nome e flechas
     */
    public ElfoNoturno(String novoNome, int novoflechas)
    {
        super(novoNome, novoflechas);
    }
    
    /**
     * Construtor de Elfo's Noturnos com nome
     */
    public ElfoNoturno(String novoNome)
    {
        super(novoNome);
        this.nome = novoNome;
        this.flechas = 42;
    }
    
    @Override
    public double atirarFlecha(Orc orc){
        if (flechas > 0 && orc.getStatus() == Status.VIVO) {
            double diminuirVida = this.vida * 0.05;
            
            flechas--;
            orc.diminuirVida(danoFlechas);
            setExp(7 * multiplicadorDeExperiencia);
            setStatus(3);
            this.vida -= diminuirVida;
            if (((int) this.getVida()) == 0) this.setStatus(1);
        }
        
        return orc.getVida();
    }
}
