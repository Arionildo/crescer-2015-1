import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste ElfoVerdeTest.
 *
 * @author  Arionildo.Escouto
 * @version 13/04/2015
 */
public class ElfoVerdeTest
{
    /**
     * Construtor default para a classe de teste ElfoVerdeTest
     */
    public ElfoVerdeTest()
    {
    }
    
    @Test
    public void elfoVerdeGanhaDobroDeExperienciaMatandoUmOrc() {
        ElfoVerde ev = new ElfoVerde("Teste1");
        Orc o = new Orc("Teste2");
        int experienciaEsperada = 14;
        
        ev.atirarFlecha(o);
        
        assertEquals(experienciaEsperada, ev.getExperiencia());
    }
    
    @Test
    public void elfoVerdeGanhaDobroDeExperienciaMatandoDoisOrcs() {
        ElfoVerde ev = new ElfoVerde("Teste1");
        Orc o = new Orc("Teste2");
        int experienciaEsperada = 28;
        
        ev.atirarFlecha(o);
        ev.atirarFlecha(o);
        
        assertEquals(experienciaEsperada, ev.getExperiencia());
    }
    
    @Test
    public void elfoVerdeAdicionaItemPermitido() {
        ElfoVerde ev = new ElfoVerde("Teste1");
        ItemDoInventario espada = new ItemDoInventario("Espada de Aço Valiriano", 1);
        
        ev.adicionarItem(espada);
        
        String descricaoEsperada = "Espada de Aço Valiriano";
        String descricaoObtida = ev.getDescricaoItens();
        
        assertEquals(descricaoEsperada, descricaoObtida);
    }
    
    @Test
    public void elfoVerdeAdicionaMaisItensPermitidos() {
        ElfoVerde ev = new ElfoVerde("Teste1");
        ItemDoInventario espada = new ItemDoInventario("Espada de Aço Valiriano", 1);
        ItemDoInventario arco01 = new ItemDoInventario("Arco e Flecha de Vidro", 2);
        ItemDoInventario arco02 = new ItemDoInventario("Arco e Flecha de Vidro", 1);
        
        ev.adicionarItem(espada);
        ev.adicionarItem(arco01);
        ev.adicionarItem(arco02);
        
        String descricaoEsperada = "Espada de Aço Valiriano,Arco e Flecha de Vidro,Arco e Flecha de Vidro";
        String descricaoObtida = ev.getDescricaoItens();
        
        assertEquals(descricaoEsperada, descricaoObtida);
    }
    
    @Test
    public void elfoVerdeAdicionaItemNaoPermitido() {
        ElfoVerde ev = new ElfoVerde("Teste1");
        ItemDoInventario lanca = new ItemDoInventario("Lança de Dorne", 1);
        
        ev.adicionarItem(lanca);
        
        String descricaoEsperada = "A lista está vazia";
        String descricaoObtida = ev.getDescricaoItens();
        
        
        assertEquals(descricaoEsperada, descricaoObtida);
    }
    
    @Test
    public void elfoVerdeAdicionaUmItemPermitidoEOutroNaoPermitido() {
        ElfoVerde ev = new ElfoVerde("Teste1");
        ItemDoInventario espada = new ItemDoInventario("Espada de Aço Valiriano", 1);
        ItemDoInventario lanca = new ItemDoInventario("Lança de Dorne", 1);
        ItemDoInventario arco02 = new ItemDoInventario("Arco e Flecha de Vidro", 1);
        
        ev.adicionarItem(espada);
        ev.adicionarItem(lanca);
        ev.adicionarItem(arco02);
        
        String descricaoEsperada = "Espada de Aço Valiriano,Arco e Flecha de Vidro";
        String descricaoObtida = ev.getDescricaoItens();
        
        assertEquals(descricaoEsperada, descricaoObtida);
    }

    /**
     * Define a .
     *
     * Chamado antes de cada método de caso de teste.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Chamado após cada método de teste de caso.
     */
    @After
    public void tearDown()
    {
    }
}
