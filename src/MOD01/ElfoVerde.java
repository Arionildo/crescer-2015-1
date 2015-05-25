import java.util.Arrays;
/**
 * Escreva a descrição da classe ElfoVerde aqui.
 * 
 * @author  Arionildo.Escouto
 * @version 20/04/2015
 */
public class ElfoVerde extends Elfo
{
    private int multiplicadorDeExperiencia = 2;
    private final String[] ITENS_PERMITIDOS = new String[] {
        "Espada de Aço Valiriano",
        "Arco e Flecha de Vidro"
    };

   /**
     * Construtor de Elfo's Verdes com nome e flechas
     */
    public ElfoVerde(String novoNome, int novoflechas)
    {
        super(novoNome, novoflechas);
    }
    
    /**
     * Construtor de Elfo's Verdes com nome
     */
    public ElfoVerde(String novoNome)
    {
        super(novoNome);
        this.nome = novoNome;
        this.flechas = 42;
    }
    
    @Override
    public double atirarFlecha(Orc orc){
        if (flechas > 0 && orc.getStatus() == Status.VIVO) {            
            flechas--;
            orc.diminuirVida(danoFlechas);
            setExp(7 * multiplicadorDeExperiencia);
            setStatus(3);
        }
        
        return orc.getVida();
    }
    
    @Override
    protected void adicionarItem(ItemDoInventario i) {
        boolean ehUmItemValido = i != null && Arrays.asList(ITENS_PERMITIDOS).contains(i.getDescricao());
       
        if (ehUmItemValido) this.item.add(i);
    }
}
