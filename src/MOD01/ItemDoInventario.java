
/**
 * Representa um item no inventário.
 * 
 * @author  Arionildo.Escouto
 * @version 08/04/2015
 */
public class ItemDoInventario
{
    String descricao;
    int quantidade;
    
    public ItemDoInventario(String novaDescricao, int novaQuantidade) {
        this.descricao = novaDescricao;
        this.quantidade = novaQuantidade;
    }
        
    public void setDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }
}
