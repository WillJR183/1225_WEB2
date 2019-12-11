package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public abstract class PessoaModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpessoa;
    
    @Column(length = 32, nullable = false)
    private String nome;
    
    @Column(length = 3, nullable = false)
    private int idade;
    
    @Column(length = 11, nullable = false)
    private long cpf;
    
    @Column(length = 10, nullable = false)
    private String sexo;
    
    public PessoaModel(String nome, int idade, long cpf, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.sexo = sexo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public long getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }
    
    public PessoaModel(){
        
    }
    
}
