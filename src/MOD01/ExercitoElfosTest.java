import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * A classe de teste ExercitoElfosTest.
 *
 * @author  Arionildo.Escouto
 * @version 20/04/2015
 */
public class ExercitoElfosTest
{
    @Test
    public void alistaNenhumElfo() {
        Elfo e1 = new Elfo("A");
        
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        
        ExercitoElfos exercito = new ExercitoElfos();
        try {
            exercito.alistarElfo(e1);
        } catch (NaoPodeAlistarException erro) {
            System.out.println(erro);
        }
        
        HashMap<String, Elfo> exercitoObtido = exercito.getExercito();
        assertEquals(exercitoEsperado, exercitoObtido);
    }
    
    @Test
    public void alistaDoisElfos() {
        Elfo e1 = new ElfoVerde("A");
        Elfo e2 = new ElfoNoturno("B");
        
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(e1.getNome(), e1);
        exercitoEsperado.put(e2.getNome(), e2);
        
        ExercitoElfos exercito = new ExercitoElfos();
        try {
            exercito.alistarElfo(e1);
            exercito.alistarElfo(e2);
        } catch (NaoPodeAlistarException erro) {
            System.out.println(erro);
        }
        
        HashMap<String, Elfo> exercitoObtido = exercito.getExercito();
        assertEquals(exercitoEsperado, exercitoObtido);
    }
    
    @Test
    public void alistaQuatroElfosExcetoElfoNormal() {
        ElfoVerde e1 = new ElfoVerde("A");
        ElfoNoturno e2 = new ElfoNoturno("B");
        Elfo e3 = new ElfoVerde("C");
        Elfo e4 = new Elfo("D");
        Elfo e5 = new ElfoVerde("E");
        
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(e1.getNome(), e1);
        exercitoEsperado.put(e2.getNome(), e2);
        exercitoEsperado.put(e3.getNome(), e3);
        exercitoEsperado.put(e5.getNome(), e5);
        
        ExercitoElfos exercito = new ExercitoElfos();
        
        try {
            exercito.alistarElfo(e1);
            exercito.alistarElfo(e2);
            exercito.alistarElfo(e3);
            exercito.alistarElfo(e5);
        } catch (NaoPodeAlistarException erro) {
            System.out.println(erro);
        }
        
        try {
            exercito.alistarElfo(e4);
        } catch (NaoPodeAlistarException erro) {
            System.out.println(erro);
        }
        
        HashMap<String, Elfo> exercitoObtido = exercito.getExercito();
        assertEquals(exercitoEsperado, exercitoObtido);
    }
    
    @Test
    public void buscaPorNomeDeUmElfo() {
        ElfoVerde e1 = new ElfoVerde("A");
        ElfoNoturno e2 = new ElfoNoturno("B");
        
        ExercitoElfos exercito = new ExercitoElfos();
        try {
            exercito.alistarElfo(e1);
        } catch (NaoPodeAlistarException erro) {
            System.out.println(erro);
        }
        
        Elfo elfoEsperado = e1;
        Elfo elfoObtido = exercito.buscarElfoPorNome("A");
        
        assertEquals(elfoEsperado, elfoObtido);
    }
    
    @Test
    public void buscaPorNomeDeUmElfoNaoAlistado() {
        ExercitoElfos exercito = new ExercitoElfos();
        
        Elfo elfoEsperado = null;
        Elfo elfoObtido = exercito.buscarElfoPorNome("A");
        
        assertEquals(elfoEsperado, elfoObtido);
    }
    
    
    
    
    //CONCLUIR
    @Test
    public void agruparElfosPorStatus() {
        ElfoVerde elfoVivo1 = new ElfoVerde("A");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfoVerde elfoVivo3 = new ElfoVerde("BB");
        ElfoVerde elfoAtacando1 = new ElfoVerde("B");
        ElfoVerde elfoAtacando2 = new ElfoVerde("C");
        elfoAtacando1.atirarFlecha(new Orc());
        elfoAtacando2.atirarFlecha(new Orc());
        HashMap<Status, ArrayList<Elfo>> esperado = new HashMap<>();
        esperado.put(Status.ATACANDO, new ArrayList<Elfo>(
            Arrays.asList(elfoAtacando1, elfoAtacando2)
        ));
        esperado.put(Status.VIVO, new ArrayList<>(
            Arrays.asList(elfoVivo3, elfoVivo2, elfoVivo1)
        ));
        ExercitoElfos exercito = new ExercitoElfos();
        try {
            exercito.alistarElfo(elfoAtacando1);
            exercito.alistarElfo(elfoAtacando2);
            exercito.alistarElfo(elfoVivo3);
            exercito.alistarElfo(elfoVivo2);
            exercito.alistarElfo(elfoVivo1);
        } catch (NaoPodeAlistarException erro) {
            System.out.println(erro);
        }
        
        exercito.agruparPorStatus();
        HashMap<Status, ArrayList<Elfo>> resultado = exercito.getExercitoPorStatus();
        
        assertEquals(esperado, resultado);
    }
}
