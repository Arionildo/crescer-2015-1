/**
 * Escreva a descrição da classe Orc aqui.
 * 
 * @author  Arionildo.Escouto
 * @version 10/04/2015
 */
public class Orc extends Personagem
{
    private final int NUMERO_SORTE = 3481;
    
    /**
     * Construtor de Orc's
     */
    public Orc()
    {
        super(110);
    }
    
    /**
     * Construtor de Orc's com nome também
     */
    public Orc(String nome)
    {
        this();
        this.nome = nome;
    }
    
    /**
     * Exibe a Vida do Orc
     */
    public String toString() {
        return "Vida Atual: "+ this.getVida();
    }
    
    protected void tentarSorte() {
        if (gerarNumero() == NUMERO_SORTE) {
            for (int i = 0; i < this.item.size(); i++) {
                int antigaQuantidade = this.item.get(i).getQuantidade();
                int novaQuantidade = antigaQuantidade + 1000;
                
                this.item.get(i).setQuantidade(novaQuantidade);
            }
        }
    }
    
    /**
     * Gera um número e compara se este é o número da sorte do Orc
     */
    private double gerarNumero() {
        double numero = 0.0;
        
        if (this.nome != null && this.nome.length() > 5) {
            numero += 65;
        } else {
            numero -= 60;
        }
        
        if (getVida() >= 30 && getVida() <= 60) {
            numero *= 2;
        } else if (getVida() < 20){
            numero *= 3;
        }
        
        if (getStatus() == Status.FUGINDO) {
            numero /= 2;
        } else if (getStatus() == Status.CACANDO || getStatus() == Status.DORMINDO) {
            numero += 1;
        }
        
        if (getExperiencia() % 2 == 0) {
            numero = Math.pow(numero, 3);
        } else if (getExperiencia() > 2) {
            numero = Math.pow(numero, 2);
        }
        
        return numero;
    }
    
    /**
     * Diminui a vida do Personagem no valor requerido
     */
    protected void diminuirVida(int valor) {
        if (gerarNumero() < 0){
            setExp(2);
            return;
        } else if (gerarNumero() > 100) {
            if (getVida() > 0) this.vida -= valor;
            if (getVida() == 0) setStatus(1);
        }
    }
}