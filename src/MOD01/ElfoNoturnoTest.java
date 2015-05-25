import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste ElfoNoturnoTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class ElfoNoturnoTest
{
    /**
     * Construtor default para a classe de teste ElfoNoturnoTest
     */
    public ElfoNoturnoTest()
    {
    }
    
    @Test
    public void elfoNoturnoGanhaTriploDeExperienciaAtacandoUmOrc() {
        ElfoNoturno en = new ElfoNoturno("Teste1");
        Orc o = new Orc("Teste2");
        int experienciaEsperada = 21;
        
        en.atirarFlecha(o);
        
        assertEquals(experienciaEsperada, en.getExperiencia());
    }
    
    @Test
    public void elfoNoturnoGanhaTriploDeExperienciaAtacandoOrcDuasVezes() {
        ElfoNoturno en = new ElfoNoturno("Teste1");
        Orc o = new Orc("Teste2");
        int experienciaEsperada = 42;
        
        en.atirarFlecha(o);
        en.atirarFlecha(o);
        
        assertEquals(experienciaEsperada, en.getExperiencia());
    }
    
    @Test
    public void elfoNoturnoPerdeVidaAoAtacar() {
        ElfoNoturno en = new ElfoNoturno("Teste1");
        Orc o = new Orc("Teste2");
        double vidaEsperada = 95;
        
        en.atirarFlecha(o);
        
        assertEquals(vidaEsperada, en.getVida(), 0.1);
    }
    
    @Test
    public void elfoNoturnoAtiraFlechaAteMorrer() {
        
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
