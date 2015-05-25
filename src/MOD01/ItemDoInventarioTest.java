

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste ItemDoInventarioTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class ItemDoInventarioTest
{
    /**
     * Construtor default para a classe de teste ItemDoInventarioTest
     */
    public ItemDoInventarioTest()
    {
    }
    
    @Test
    public void itemCriadoComQuantidadeEDescricao() {
        ItemDoInventario i = new ItemDoInventario("Item de cura", 5);
        int quantidadeEsperada = 5;
        String descricaoEsperada = "Item de cura";
        
        assertEquals(quantidadeEsperada, i.getQuantidade());
        assertEquals(descricaoEsperada, i.getDescricao());
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
