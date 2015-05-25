import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste ElfoTest.
 *
 * @author  Arionildo.Escouto
 * @version 14/04/2015
 */
public class ElfoTest
{
    /**
     * Construtor default para a classe de teste ElfoTest
     */
    public ElfoTest()
    {
    }

    @Test
    public void diminuiFlecha() {
        Elfo e = new Elfo("Teste");
        Orc o = new Orc();
        int esperado = e.getFlechas() - 1;
        e.atirarFlecha(o);
        int resultado = e.getFlechas();
        
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void elfoComNomeInformado() {
        String esperado = "Teste";
        Elfo e = new Elfo(esperado);
        
        assertEquals(esperado, e.getNome());
    }
    
    @Test
    public void elfoComNomeVazio() {
        String esperado = "";
        Elfo e = new Elfo(esperado);
        
        assertEquals(esperado, e.getNome());
    }
    
    @Test
    public void elfoComNomeNulo() {
        String esperado = null;
        Elfo e = new Elfo(esperado);
        
        assertEquals(esperado, e.getNome());
    }
    
    @Test
    public void elfoComFlechasPadrão() {
        int esperado = 42;
        Elfo e = new Elfo("Teste");
        
        assertEquals(esperado, e.getFlechas());
    }
    
    @Test
    public void elfoComNomeEMuitasFlechas() {
        String nomeEsperado = "Teste";
        int flechasEsperadas = 654654;
        Elfo e = new Elfo(nomeEsperado, flechasEsperadas);
        
        assertEquals(nomeEsperado, e.getNome());
        assertEquals(flechasEsperadas, e.getFlechas());
    }
    
    /**
     * 
     * TESTES DE ATAQUE
     * 
     */
    @Test
    public void elfoAtacaOrc() {
        String nome = "Teste1";
        Elfo e = new Elfo(nome);
        Orc o = new Orc();
        int expEsperado = 7;
        int flechasEsperadas = 41;
        
        e.atirarFlecha(o);
        
        assertEquals(expEsperado, e.getExperiencia());
        assertEquals(flechasEsperadas, e.getFlechas());
    }
    
    @Test
    public void elfoAtacaOrcsDiferentes() {
        String nome = "Teste1";
        Elfo e = new Elfo(nome);
        Orc oA = new Orc("Teste2");
        Orc oB = new Orc("Teste3");
        int vidaOrcA = 100;
        int vidaOrcB = 100;
        int expEsperado = 14;
        int flechasEsperadas = 40;
        
        e.atirarFlecha(oA);
        e.atirarFlecha(oB);
        
        assertEquals(expEsperado, e.getExperiencia());
        assertEquals(flechasEsperadas, e.getFlechas());
        assertEquals(vidaOrcA, oA.getVida(), 0.1);
        assertEquals(vidaOrcB, oB.getVida(), 0.1);
    }
    
    @Test
    public void elfoMataOrc() {
        String nome = "Teste1";
        Elfo e = new Elfo(nome);
        Orc o = new Orc("Teste2");
        int flechasEsperadas = 31;
        double vidaOrcEsperada = 0;
        
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        
        assertEquals(vidaOrcEsperada, o.getVida(), 0.1);
        assertEquals(flechasEsperadas, e.getFlechas());
    }
    
    @Test
    public void elfoEsgotaFlechas() {
        String nome = "Teste1";
        Elfo e = new Elfo(nome, 2);
        Orc o = new Orc();
        int expEsperado = 14;
        int flechasEsperadas = 0;
        
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        
        assertEquals(expEsperado, e.getExperiencia());
        assertEquals(flechasEsperadas, e.getFlechas());
    }
    
    /**
     * 
     * TESTES MÉTODO toString()
     * 
     */
    @Test
    public void elfoToString() {
        Elfo e = new Elfo("Teste");
        String esperado = "Teste possui 42 flechas e 0 níveis de experiência.";
        
        assertEquals(esperado, e.toString());
    }
    
    @Test
    public void elfoToStringAposDoisAtaque() {
        Elfo e = new Elfo("Teste1");
        Orc o = new Orc();
        String esperado = "Teste1 possui 40 flechas e 14 níveis de experiência.";
        
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        
        assertEquals(esperado, e.toString());
    }
    
    @Test
    public void elfoToStringAposMatarOrc() {
        Elfo e = new Elfo("Teste2");
        Orc o = new Orc("Teste2");
        String esperado = "Teste2 possui 31 flechas e 77 níveis de experiência.";
        
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        e.atirarFlecha(o);
        
        assertEquals(esperado, e.toString());
    }
    
    @Test
    public void contadorDeTresElfosDaMesmaRaca() {
        Elfo.resetContagem();
        Elfo e1 = new Elfo("A");
        Elfo e2 = new Elfo("B");
        Elfo e3 = new Elfo("C");
        
        int contagemEsperada = 3;
        int contagemObtida = Elfo.getContagem();
        
        assertEquals(contagemEsperada, contagemObtida);
        Elfo.resetContagem();
    }
    
    @Test
    public void contadorDeQuatroElfosDeRacasDiferentes() {
        Elfo.resetContagem();
        Elfo e = new Elfo("A");
        Elfo ev1 = new ElfoVerde("B");
        Elfo en = new ElfoNoturno("C");
        ElfoVerde ev2 = new ElfoVerde("D");
        
        int contagemEsperada = 4;
        int contagemObtida = Elfo.getContagem();
        
        assertEquals(contagemEsperada, contagemObtida);
    }
}
