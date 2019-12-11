package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "idpessoa")
public class AlunoModel extends PessoaModel implements Serializable{
    private int ra;
    
    @ManyToMany(mappedBy = "listaDeAlunos")
    private List<CursoModel> listaDeCursos = new ArrayList<>();
    
    //#########################################\\

    public List<CursoModel> getListaDeCursos() {
        return listaDeCursos;
    }

    public void setListaDeCursos(List<CursoModel> listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }
    
    public AlunoModel(String nome, int idade, long cpf, String sexo) {
        super(nome, idade, cpf, sexo);
    }
        
    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }
    
    public AlunoModel(){
        
    }
    
    
}
