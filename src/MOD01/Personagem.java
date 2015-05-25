import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe abstrata Personagem - Classe Super
 * 
 * @author  Arionildo.Escouto
 * @version 10/04/2015
 */
public abstract class Personagem
{
    protected Status status = Status.VIVO;
    protected double vida;
    protected int experiencia;
    protected String nome;
    protected ArrayList<ItemDoInventario> item = new ArrayList<ItemDoInventario>();    
    
    protected Personagem(double vida) {
        this.vida = vida;
        this.nome = "";
    }
    
    /**
     * Retorna o estado do Personagem
     */
    protected Status getStatus() {
        return this.status;
    }
    
    protected void setStatus(int indice) {
        switch (indice) {
            case 0: this.status = Status.VIVO; break;
            case 1: this.status = Status.MORTO; break;
            case 2: this.status = Status.FERIDO; break;
            case 3: this.status = Status.ATACANDO; break;
            case 4: this.status = Status.FUGINDO; break;
            case 5: this.status = Status.CACANDO; break;
            case 6: this.status = Status.DORMINDO; break;
            default: ;
        }
    }
    
    /**
     * Mostra a vida atual do Personagem
     */
    protected double getVida() {
        return this.vida;
    }
    
    protected void setExp(int novoExp){
        this.experiencia += novoExp;
    }
    
    protected int getExperiencia() {
        return this.experiencia;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    protected void adicionarItem(ItemDoInventario i) {
        this.item.add(i);
    }
    
    protected void perderItem(ItemDoInventario i) {
        this.item.remove(i);
    }
    
    protected ArrayList<ItemDoInventario> getItens(){
        return this.item;
    }
    
    protected String getDescricaoItens() {
        String listaDescricoes = this.item.isEmpty() ? "A lista está vazia" : this.item.get(0).getDescricao();
        
        for (int i = 1; i < this.item.size(); i++) {
            if (this.item.size() - 2 < this.item.size() - 1) {
                listaDescricoes += ",";
                listaDescricoes += this.item.get(i).getDescricao();
            } else {
                listaDescricoes += this.item.get(i).getDescricao();
            }
        }
        
        return listaDescricoes;
    }
    
    protected ItemDoInventario getItemComMaiorQuantidade() {
        boolean temItens = !this.item.isEmpty();
        int tamanhoDoInventario = this.item.size();
        ItemDoInventario maiorQuantidade = null;
        
        if (temItens) {
            maiorQuantidade = this.item.get(0);
            for (int i = 1; i < tamanhoDoInventario; i++) {
                ItemDoInventario it = this.item.get(i);
                int quantidadeItem = it.getQuantidade();
                
                if (quantidadeItem > maiorQuantidade.getQuantidade()) maiorQuantidade = it;
            }
        }
        
        return maiorQuantidade;
    }
    
    protected ItemDoInventario getItemComMenorQuantidade() {
        boolean temItens = !this.item.isEmpty();
        int tamanhoDoInventario = this.item.size();
        ItemDoInventario menorQuantidade = null;
        
        if (temItens) {
            menorQuantidade = this.item.get(0);
            for (int i = 1; i < tamanhoDoInventario; i++) {
                ItemDoInventario it = this.item.get(i);
                int quantidadeItem = it.getQuantidade();
                
                if (quantidadeItem < menorQuantidade.getQuantidade()) menorQuantidade = it;
            }
        }
        
        return menorQuantidade;
    }
   
    protected void ordenarItens() {
       ArrayList<ItemDoInventario> novoInventario = new ArrayList<ItemDoInventario>();
       int limite = this.item.size();
       
       for (int i = 0; i < limite; i++) {
           ItemDoInventario itemAtual = getItemComMenorQuantidade();
           
           novoInventario.add(itemAtual);
           this.item.remove(itemAtual);
       }
       
       this.item = novoInventario;
    }
}
