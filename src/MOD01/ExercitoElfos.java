import java.util.*;
/**
 * Escreva a descrição da classe ExercitoElfos aqui.
 * 
 * @author  Arionildo.Escouto
 * @version 15/04/2015
 */
public class ExercitoElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> grupo = new HashMap<>();
    private EstrategiaAtaque estrategia = new EstrategiaNormal();
    
    public HashMap<String, Elfo> getExercito() {
        return this.exercito;
    }
    
    public HashMap<Status, ArrayList<Elfo>> getExercitoPorStatus() {
        return this.grupo;
    }
    
    public void alistarElfo(Elfo e) throws NaoPodeAlistarException{
        boolean podeAlistar = e instanceof ElfoVerde || e instanceof ElfoNoturno;
        
        if (podeAlistar) {
            exercito.put(e.getNome(), e);
        } else {
            throw new NaoPodeAlistarException();
        }
    }
    
    public Elfo buscarElfoPorNome(String nome) {
        return exercito.get(nome);
    }
    
    public ArrayList<Elfo> buscar(Status status) {
        agruparPorStatus();
        return grupo.get(status);
    }
    
    public void agruparPorStatus() {
        grupo.clear();
        
        for (Map.Entry<String, Elfo> chave: exercito.entrySet()) {
            Elfo elfo = chave.getValue();
            Status status = elfo.getStatus();
            
            if (grupo.containsKey(status)) {
                grupo.get(status).add(elfo);
            } else {
                grupo.put(status, new ArrayList<>(Arrays.asList(elfo)));
            }
        }
    }
}