
package modelo;

public class Professor extends Pessoa{
    private int siape;

    public Professor(String nome, String sexo, String cpf, int idade){
        super.setNome(nome);
        super.setSexo(sexo);
        super.setCpf(cpf);
        super.setIdade(idade);
    }

    public Professor() {}
    
    public int getSiape() {
        return siape;
    }
    public void setSiape(int siape) {
        this.siape = siape;
    }
}
