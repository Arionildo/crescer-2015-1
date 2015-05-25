import java.util.*;
/**
 * Escreva a descrição da classe EstrategiaNormal aqui.
 * 
 * @author  Arionildo.Escouto
 * @version 20/04/2015
 */
public class EstrategiaNormal implements EstrategiaAtaque {
    private ArrayList<Elfo> ordemAtaque = new ArrayList<>();
    
    public void atacarOrcs(ArrayList<Elfo> e, ArrayList<Orc> o) {
        System.out.println("Estratégia normal");
        
        for (Elfo elfo : e) {
            ordemAtaque.add(elfo);
            for (Orc orc : o) {
                elfo.atirarFlecha(orc);
            }
        }        
    }
    
    public ArrayList<Elfo> getOrdemUltimoAtaque() {
        return ordemAtaque;
    }
}