
/**
 * Escreva a descrição da classe NaoPodeAlistarException aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class NaoPodeAlistarException extends Exception
{
    public NaoPodeAlistarException() {
        super("Houve uma falha ao alistar o elfo. Verifique com o Administrador qual é o erro.");
    }
}
